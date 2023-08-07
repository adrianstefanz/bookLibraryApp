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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String reviewTitle;
    private String reviewText;

    @ManyToOne
    @JoinColumn(name = "id")
    private Book book;

    @ManyToOne
    private User user;

}
