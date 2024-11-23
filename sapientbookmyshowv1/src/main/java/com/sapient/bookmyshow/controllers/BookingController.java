package com.sapient.bookmyshow.controllers;

import com.sapient.bookmyshow.dtos.CreateBookingRequest;
import com.sapient.bookmyshow.models.Booking;
import com.sapient.bookmyshow.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;
    // Create a booking
    @PostMapping("/booking")
    public Booking createBooking(@RequestBody CreateBookingRequest request) {
        return bookingService.createBooking(request);
    }
}