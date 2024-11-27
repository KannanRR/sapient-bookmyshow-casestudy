package com.theatre.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TheatreBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheatreBookingApplication.class, args);
    }

}
