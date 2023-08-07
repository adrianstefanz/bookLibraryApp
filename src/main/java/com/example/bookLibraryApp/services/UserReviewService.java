package com.example.bookLibraryApp.services;

import com.example.bookLibraryApp.dtos.UserReviewDto;
import com.example.bookLibraryApp.entities.UserReview;
import com.example.bookLibraryApp.mappers.BookMapper;
import com.example.bookLibraryApp.mappers.UserMapper;
import com.example.bookLibraryApp.mappers.UserReviewMapper;
import com.example.bookLibraryApp.repositories.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserReviewService {

    @Autowired
    private UserReviewRepository userReviewRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    public List<UserReviewDto> getReviewsByBook(String title) {
        List<UserReviewDto> userReviewsByBooks = new ArrayList<>();
        for (UserReview u : userReviewRepository.findAllReviewsByBook(title)) {
            userReviewsByBooks.add(UserReviewMapper.entityToDto(u));
        }
        return userReviewsByBooks;
    }

    public List<UserReviewDto> getReviewsByUser(String userName) {
        List<UserReviewDto> userReviewsByUser = new ArrayList<>();
        for (UserReview u : userReviewRepository.findAllReviewsByUser(userName)) {
            userReviewsByUser.add(UserReviewMapper.entityToDto(u));
        }
        return userReviewsByUser;
    }

    public void addNewReview(UserReviewDto userReviewDto) {
        userReviewRepository.save(UserReviewMapper.dtoToEntity(
                userReviewDto,
                BookMapper.dtoToEntity(bookService.getBookById(userReviewDto.getBookId()))
                /*UserMapper.dtoToEntity(userService.getUserById(userReviewDto.getUserId())))*/));
    }


}
