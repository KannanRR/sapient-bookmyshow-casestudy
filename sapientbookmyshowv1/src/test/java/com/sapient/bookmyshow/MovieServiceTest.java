package com.sapient.bookmyshow;

import com.sapient.bookmyshow.models.Movie;
import com.sapient.bookmyshow.models.Show;
import com.sapient.bookmyshow.repositories.MovieRepository;
import com.sapient.bookmyshow.services.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void testGetMovie_Success() {
        Long movieId = 1L;
        Movie mockMovie = Movie.builder().name("Inception").rating(9.0).build();

        Mockito.when(movieRepository.findById(movieId)).thenReturn(Optional.of(mockMovie));

        Movie result = movieService.getMovie(movieId);

        assertEquals(mockMovie, result);
        Mockito.verify(movieRepository, Mockito.times(1)).findById(movieId);
    }

    @Test
    public void testGetMovie_NotFound() {
        Long movieId = 2L;

        Mockito.when(movieRepository.findById(movieId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(NoSuchElementException.class, () -> movieService.getMovie(movieId));

        assertEquals("Movie not found: 2", exception.getMessage());
    }

    @Test
    public void testGetMovieByDate() {
        Long movieId = 1L;
        String date = "2023-11-20";
        LocalDate localDate = LocalDate.parse(date);

        Movie mockMovie = new Movie();
        mockMovie.setShows(List.of(
                Show.builder().startDate(localDate).build(),
                Show.builder().startDate(LocalDate.of(2023, 11, 19)).build()
        ));

        Mockito.when(movieRepository.findMoviesByShowStartDate(localDate, movieId)).thenReturn(mockMovie);

        Movie result = movieService.getMovieByDate(movieId, date);

        assertEquals(1, result.getShows().size());
        assertTrue(result.getShows().get(0).getStartDate().isEqual(localDate));
    }

    @Test
    public void testCreateMovie() {
        Movie newMovie = Movie.builder().name("Interstellar").rating(8.9).build();

        Mockito.when(movieRepository.save(Mockito.any(Movie.class))).thenReturn(newMovie);

        Movie result = movieService.createMovie(newMovie);

        assertNotNull(result);
        assertEquals("Interstellar", result.getName());
        Mockito.verify(movieRepository, Mockito.times(1)).save(newMovie);
    }

    @Test
    public void testSearchMovie() {
        String movieName = "Avatar";
        List<Movie> mockMovies = List.of(
                Movie.builder().name("Avatar").rating(8.0).build(),
                Movie.builder().name("Avatar: The Way of Water").rating(7.8).build()
        );

        Mockito.when(movieRepository.findByNameContaining(movieName)).thenReturn(mockMovies);

        List<Movie> result = movieService.searchMovie(movieName);

        assertEquals(2, result.size());
        Mockito.verify(movieRepository, Mockito.times(1)).findByNameContaining(movieName);
    }
}

