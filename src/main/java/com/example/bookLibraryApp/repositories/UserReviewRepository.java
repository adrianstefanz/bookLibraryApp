package com.example.bookLibraryApp.repositories;

import com.example.bookLibraryApp.entities.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Long> {

    @Query("SELECT u FROM UserReview u WHERE LOWER(u.book) = LOWER(:title)")
    List<UserReview> findAllReviewsByBook(@Param("title") String title);

    @Query("SELECT u FROM UserReview u WHERE LOWER(u.book) = LOWER(:userName)")
    List<UserReview> findAllReviewsByUser(@Param("userName") String userName);

}
