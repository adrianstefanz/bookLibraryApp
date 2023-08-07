package com.example.bookLibraryApp.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReviewDto {
    private Long ReviewId;
    private String reviewTitle;
    private String reviewText;
//    private Long userId;
    private Long bookId;
}

