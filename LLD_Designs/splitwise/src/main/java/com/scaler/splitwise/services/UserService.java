package com.scaler.splitwise.services;

import com.scaler.splitwise.exceptions.UserNotFoundException;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String phone, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);

        return this.userRepository.save(user);
    }

    public User updateUser(Long id, String password) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("user id provided is wrong");
        }
        User user = userOptional.get();
        user.setPassword(password);
        return userRepository.save(user);
    }

}






















