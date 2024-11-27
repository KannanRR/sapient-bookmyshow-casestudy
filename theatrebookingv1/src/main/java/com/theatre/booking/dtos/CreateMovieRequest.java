package com.theatre.booking.dtos;

import com.theatre.booking.enums.MovieFeature;
import com.theatre.booking.enums.Language;
import com.theatre.booking.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateMovieRequest {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> features = new ArrayList<>();

    public Movie toMovie() {
        return Movie.builder()
                .name(name)
                .rating(rating)
                .features(features)
                .languages(languages)
                .isDeleted(false)
                .build();
    }

}
