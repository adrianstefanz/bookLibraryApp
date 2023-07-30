package com.example.bookLibraryApp.controllers;

import com.example.bookLibraryApp.dtos.UserDto;
import com.example.bookLibraryApp.exceptions.BookException;
import com.example.bookLibraryApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {


    @Autowired
    private UserService userService;

    // Method to add a new user
    @PostMapping
    public ResponseEntity<String> addNewUser(@RequestBody UserDto userDto) {
        try {
            userService.addNewUser(userDto);
            return new ResponseEntity<>("User with title: " + userDto.getUsername() + " added to the library.", HttpStatus.CREATED);
        } catch (BookException e){
            return new ResponseEntity<>("Exception in adding book with title: " + userDto.getUsername() + "." + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
