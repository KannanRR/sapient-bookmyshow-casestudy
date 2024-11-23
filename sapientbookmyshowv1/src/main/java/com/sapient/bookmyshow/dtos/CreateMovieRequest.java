package com.sapient.bookmyshow.dtos;

import com.sapient.bookmyshow.enums.MovieFeature;
import com.sapient.bookmyshow.enums.Language;
import com.sapient.bookmyshow.models.Movie;
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
