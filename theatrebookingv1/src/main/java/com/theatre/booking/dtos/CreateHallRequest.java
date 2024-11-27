package com.theatre.booking.dtos;

import com.theatre.booking.enums.MovieFeature;
import com.theatre.booking.enums.SeatType;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CreateHallRequest {
    private String name;
    private List<MovieFeature> features = new ArrayList<>();
    private Map<SeatType, List<SeatPosition>> seatRanges = new HashMap<>();
}