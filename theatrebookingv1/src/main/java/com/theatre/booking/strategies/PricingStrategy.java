package com.theatre.booking.strategies;

import com.theatre.booking.models.Booking;

public interface PricingStrategy {
    Double calculatePrice(Booking booking);
}
