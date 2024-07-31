package com.enes.question.services;

import com.enes.question.entities.User;
import com.enes.question.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
UserRepository userRepository;

public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
