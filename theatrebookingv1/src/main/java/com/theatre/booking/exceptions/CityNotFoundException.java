package com.theatre.booking.exceptions;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(Long id) {
        super("City with id: " +  id + " not found");
    }
}
