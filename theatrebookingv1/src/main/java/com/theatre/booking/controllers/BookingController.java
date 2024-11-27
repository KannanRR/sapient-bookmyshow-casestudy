package com.theatre.booking.controllers;

import com.theatre.booking.dtos.CreateBookingRequest;
import com.theatre.booking.models.Booking;
import com.theatre.booking.services.BookingService;
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