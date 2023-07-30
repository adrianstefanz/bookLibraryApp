package com.example.bookLibraryApp.repositories;

import com.example.bookLibraryApp.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) = LOWER(:title)")
    Book findBookByTitle(@Param("title") String title);

}
