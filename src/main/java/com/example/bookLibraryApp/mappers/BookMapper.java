package com.example.bookLibraryApp.mappers;

import com.example.bookLibraryApp.dtos.BookDto;
import com.example.bookLibraryApp.entities.Book;

public class BookMapper {
    public static BookDto entityToDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .yearPublished(book.getYearPublished())
                .build();
    }

    public static Book dtoToEntity(BookDto bookDto){
        return Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .yearPublished(bookDto.getYearPublished())
                .build();
    }
}
