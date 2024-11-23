package com.sapient.bookmyshow.exceptions;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(Long id) {
        super("City with id: " +  id + " not found");
    }
}
