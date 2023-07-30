package com.example.bookLibraryApp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private int yearPublished;

    @OneToMany(mappedBy="book")
    private Set<UserReview> reviews;

    public void addReview(UserReview review){
        reviews.add(review);
        review.setBook(this);
    }
    public void removeReview(UserReview review){
        reviews.remove(review);
        review.setBook(null);
    }
}
