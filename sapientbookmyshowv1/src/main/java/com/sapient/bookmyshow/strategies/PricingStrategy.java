package com.sapient.bookmyshow.strategies;

import com.sapient.bookmyshow.models.Booking;

public interface PricingStrategy {
    Double calculatePrice(Booking booking);
}
