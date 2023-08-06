package com.example.bookLibraryApp.mappers;

import com.example.bookLibraryApp.dtos.UserReviewDto;
import com.example.bookLibraryApp.entities.Book;
import com.example.bookLibraryApp.entities.User;
import com.example.bookLibraryApp.entities.UserReview;

public class UserReviewMapper {

    public static UserReviewDto entityToDto(UserReview userReview){
        return UserReviewDto.builder()
                .id(userReview.getReviewId())
                .reviewText(userReview.getReviewText())
                .bookId(userReview.getBook().getId())
                .userId(userReview.getUser().getId())
                .build();
    }

    public static UserReview dtoToEntity(UserReviewDto userReviewDto, Book book, User user){
        UserReview userReview = UserReview.builder()
                .reviewId(userReviewDto.getId())
                .reviewText(userReviewDto.getReviewText())
                .book(book)
                .user(user)
                .build();
        user.addReview(userReview);
        book.addReview(userReview);
        return userReview;
    }

}
