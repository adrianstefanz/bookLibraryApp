package com.example.bookLibraryApp.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "userReview")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReview {

    @Id
    @GeneratedValue
    private Long reviewId;
    private String reviewText;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

}
