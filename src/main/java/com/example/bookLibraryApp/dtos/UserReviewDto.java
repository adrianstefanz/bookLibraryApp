package com.example.bookLibraryApp.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserReviewDto {
    private Long id;
    private String reviewText;
    private Long userId;
    private Long bookId;
}

