package com.sapient.bookmyshow.exceptions;

public class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException() {
        super("Email is mandatory");
    }
}
