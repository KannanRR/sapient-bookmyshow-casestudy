package com.sapient.bookmyshow.services;

import com.sapient.bookmyshow.exceptions.CityNotFoundException;
import com.sapient.bookmyshow.models.City;
import com.sapient.bookmyshow.models.Movie;
import com.sapient.bookmyshow.models.Show;
import com.sapient.bookmyshow.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    public Movie getMovie(Long movieId) {
        /*return movieRepository
                .findById(movieId)
                .orElseThrow(() -> new NoSuchElementException("Movie not found: " + movieId));*/
        return movieRepository
                .findMovieByIdAndIsDeletedFalse(movieId)
                .orElseThrow(() -> new NoSuchElementException("Movie not found: " + movieId));
    }

    public Movie getMovieByDate(Long movieId, String startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(startDate, formatter);
        System.out.println("Date - " + localDate);

        Movie movieObj = movieRepository.findMoviesByShowStartDate(localDate, movieId);

        List<Show> showObj = movieObj.getShows().stream()
                .filter(show -> show.getStartDate().isEqual(localDate))
                .toList();

        movieObj.setShows(showObj);

        return movieObj;
        //return movieRepository.findByIdAndShowsStartDate(movieId, localDate);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> searchMovie(String moviename) {
        //return movieRepository.findByNameContaining(moviename);
        return movieRepository.findByNameContainingAndIsDeletedFalse(moviename);
    }

    public Movie updateMovie(Long id, Movie request) {
        Movie existingMovie = movieRepository.findMovieByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));

        existingMovie.setName(request.getName());
        existingMovie.setRating(request.getRating());
        return movieRepository.save(existingMovie);
    }

    public Movie deleteMovie(Long id) {
        Movie existingMovie = movieRepository.findMovieByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));

        existingMovie.setIsDeleted(true);

        return movieRepository.save(existingMovie);
    }
}
