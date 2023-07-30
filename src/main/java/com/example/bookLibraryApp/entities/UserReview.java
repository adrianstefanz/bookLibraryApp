package com.example.bookLibraryApp.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "userReview")
@Builder
public class UserReview {

    @Id
    @GeneratedValue
    private Long id;
    private String reviewText;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

}
