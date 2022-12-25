package com.scaler.splitwise.controllers;

import com.scaler.splitwise.exceptions.UserNotFoundException;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User createUser(String name, String phone, String password) {
        return userService.createUser(name, phone, password);
    }
    public User updateProfile(Long id, String password) {
        User user = null;
        try{
            user = userService.updateUser(id, password);
        } catch (UserNotFoundException e) {
            System.out.println("Some Exception Occured");
            System.out.println(e);
        }

        return user;
    }

}
