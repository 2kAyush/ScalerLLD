package com.scaler.splitwise;

import com.scaler.splitwise.controllers.UserController;
import com.scaler.splitwise.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://github.com/Naman-Bhalla/splitwiseJune22/tree/master/src/main/java/com/scaler/splitwisejune22
// refer this for the working code of splitwise!.

// this code is incomplete!.

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
    private UserController userController;
    @Autowired
    public SplitwiseApplication(UserController userController) {
        this.userController = userController;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a user:
        User user = this.userController.createUser("Ayush", "384576478", "Hello@1234");
        System.out.println(user);
        // update user
//        User user = userController.updateProfile(1L, "changed_password");
//        System.out.println(user);

    }
}
