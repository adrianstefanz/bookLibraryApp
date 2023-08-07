package com.example.bookLibraryApp.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;

    @OneToMany(mappedBy="user")
    private Set<UserReview> reviews;

    public void addReview(UserReview review){
        reviews.add(review);
//        review.setUser(this);
    }
    public void removeReview(UserReview review){
        reviews.remove(review);
//        review.setUser(null);
    }

}
