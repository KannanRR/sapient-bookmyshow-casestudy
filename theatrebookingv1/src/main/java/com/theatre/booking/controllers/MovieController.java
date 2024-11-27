package com.theatre.booking.controllers;

import com.theatre.booking.dtos.CreateMovieRequest;
import com.theatre.booking.dtos.CreateMovieResponse;
import com.theatre.booking.models.Movie;
import com.theatre.booking.services.MovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @GetMapping("/{id}/{date}")
    public Movie getMoviebyDate(@PathVariable Long id, @PathVariable String date) {
        return movieService.getMovieByDate(id, date);
    }

    @PostMapping
    public Movie createMovie(@RequestBody CreateMovieRequest request) {
        return movieService.createMovie(request.toMovie());
    }

    @GetMapping("/search/{movie}")
    public List<Movie> searchMovie(@PathVariable String movie) {
        //return toMovieResponseDTO(movieService.searchMovie(movie));
        return movieService.searchMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody CreateMovieRequest request) {
        return movieService.updateMovie(id, request.toMovie());
    }

    @DeleteMapping("/{id}")
    public Movie deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }

    private List<CreateMovieResponse> toMovieResponseDTO(List<Movie> movie) {
        return movie.stream()
                .map(movies -> modelMapper.map(movies, CreateMovieResponse.class))
                .toList();
    }
}