package com.theatre.booking.services;

import com.theatre.booking.exceptions.ResourceNotFoundException;
import com.theatre.booking.models.Movie;
import com.theatre.booking.models.Show;
import com.theatre.booking.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
                .orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + movieId + " not found"));
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
                .orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + id + " not found"));

        existingMovie.setName(request.getName());
        existingMovie.setRating(request.getRating());
        return movieRepository.save(existingMovie);
    }

    public Movie deleteMovie(Long id) {
        Movie existingMovie = movieRepository.findMovieByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + id + " not found"));

        existingMovie.setIsDeleted(true);

        return movieRepository.save(existingMovie);
    }
}
