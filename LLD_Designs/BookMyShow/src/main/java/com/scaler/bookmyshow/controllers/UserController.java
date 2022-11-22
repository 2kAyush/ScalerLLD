package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dto.CreateUserRequestDto;
import com.scaler.bookmyshow.dto.CreateUserResponseDto;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto){
        User savedUser = userService.createUser(createUserRequestDto.getEmail());
        CreateUserResponseDto responseDto = new CreateUserResponseDto();
        responseDto.setUser(savedUser);
        return responseDto;
    }
}
