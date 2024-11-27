package com.theatre.booking.services;

import com.theatre.booking.dtos.CreateCustomerDTO;
import com.theatre.booking.exceptions.ResourceNotFoundException;
import com.theatre.booking.models.Customer;
import com.theatre.booking.models.User;
import com.theatre.booking.repositories.CustomerRepository;
import com.theatre.booking.exceptions.EmailAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private UserService userService;

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + id + " not found"));
    }

    public Customer createCustomer(CreateCustomerDTO request) {
        // Validate if the email is not present
        // If present, throw an error
        String email = request.getEmail();
        Optional<Customer> existingCustomer = customerRepository.findCustomerByEmail(email);
        if (existingCustomer.isPresent()) {
            throw new EmailAlreadyExistsException(email);
        }

        // Create the user
        User user = userService.createUser(request.getUsername(), request.getPassword());

        // Create the customer
        Customer customer = Customer.builder()
                .city(request.getCity())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .fullName(request.getFullName())
                .user(user)
                .build();

        return customerRepository.save(customer);
    }

    public Customer getCustomerInternal(Long userId) {
        return customerRepository.findById(userId).orElse(null);
    }
}
