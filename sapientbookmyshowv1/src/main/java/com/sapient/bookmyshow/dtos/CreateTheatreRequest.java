package com.sapient.bookmyshow.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class CreateTheatreRequest {
    private Long cityid;
    private String name;
    private String address;
    private List<Long> halls = new ArrayList<>();
    private List<Long> shows = new ArrayList<>();
}
