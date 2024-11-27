package com.theatre.booking.services;

import com.theatre.booking.models.User;
import com.theatre.booking.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public User createUser(String username, String password) {
        User user = new User(username, password);
        return userRepository.save(user);
    }
}
