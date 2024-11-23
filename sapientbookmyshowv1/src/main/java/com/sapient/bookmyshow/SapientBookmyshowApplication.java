package com.sapient.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SapientBookmyshowApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapientBookmyshowApplication.class, args);
    }

}
