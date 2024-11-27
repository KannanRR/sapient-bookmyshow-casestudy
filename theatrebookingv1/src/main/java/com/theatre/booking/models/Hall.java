package com.theatre.booking.models;

import com.theatre.booking.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Hall extends BaseModel {

    private String name;

    @OneToMany(mappedBy = "hall")
    private List<Seat> seats = new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted = false;
}