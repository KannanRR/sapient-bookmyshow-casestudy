package com.theatre.booking.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeatPosition {
    private Integer rowNo;
    private Integer columnNo;
}