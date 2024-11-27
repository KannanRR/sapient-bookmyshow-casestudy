package com.theatre.booking.exceptions;

public class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException() {
        super("Email is mandatory");
    }
}
