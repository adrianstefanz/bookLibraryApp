package com.example.bookLibraryApp.controllers;

import com.example.bookLibraryApp.dtos.UserReviewDto;
import com.example.bookLibraryApp.services.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reviews")
public class UserReviewController {

    @Autowired
    private UserReviewService userReviewService;

    @GetMapping(path = "/book/{title}")
    public ResponseEntity<List<UserReviewDto>> getReviewsByBook(@PathVariable(value="title") String title){
        return new ResponseEntity<>(userReviewService.getReviewsByBook(title), HttpStatus.OK);
    }

    @GetMapping(path = "/book/{username}")
    public ResponseEntity<List<UserReviewDto>> getReviewsByUsername(@PathVariable(value="username") String username){
        return new ResponseEntity<>(userReviewService.getReviewsByUser(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createNewReview(@RequestBody UserReviewDto userReviewDto){
        userReviewService.addNewReview(userReviewDto);
        return new ResponseEntity<>("Review added", HttpStatus.OK);
    }


}