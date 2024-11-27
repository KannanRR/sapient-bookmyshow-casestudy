package com.theatre.booking.controllers;

import com.theatre.booking.dtos.CreateCustomerDTO;
import com.theatre.booking.models.Customer;
import com.theatre.booking.services.CustomerService;
import com.theatre.booking.exceptions.InvalidCustomerException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;
    // Get a customer
    // GET /customer/{id}
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }
    // Create a customer
    // POST /customer
    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerDTO request) {
        validate(request);
        return customerService.createCustomer(request);
    }

    private void validate(CreateCustomerDTO request) {
        if (request.getEmail() == null) {
            throw new InvalidCustomerException();
        }
    }
}
