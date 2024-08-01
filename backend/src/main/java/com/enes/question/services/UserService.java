package com.enes.question.services;

import com.enes.question.entities.User;
import com.enes.question.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
private UserRepository userRepository;

public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createOneUser(User newUser) { return userRepository.save(newUser);
    }


    public User findById(Long userId) { return userRepository.findById(userId).orElse(null);
    }


    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User userToUpdate = user.get();
            userToUpdate.setUserName(newUser.getUserName());
            userToUpdate.setPassword(newUser.getPassword());
            userRepository.save(userToUpdate);
            return userToUpdate;
        } else {
            return null;
        }


    }

    public void deleteOneUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
