package com.example.bookLibraryApp.services;

import com.example.bookLibraryApp.dtos.BookDto;
import com.example.bookLibraryApp.entities.Book;
import com.example.bookLibraryApp.exceptions.BookException;
import com.example.bookLibraryApp.mappers.BookMapper;
import com.example.bookLibraryApp.repositories.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDto getBookByTitle(String title) {
        return BookMapper.entityToDto(bookRepository.findBookByTitle(title));
    }

    public BookDto getBookById(Long bookId) {
        return BookMapper.entityToDto(bookRepository.findById(bookId).get());
    }

    public List<BookDto> getBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            bookDtos.add(BookMapper.entityToDto(book));
        }
        return bookDtos;
    }

    public void addNewBook(@NotNull BookDto bookDto) {
        if (bookRepository.findBookByTitle(bookDto.getTitle()) == null) {
            this.bookRepository.save(BookMapper.dtoToEntity(bookDto));
        } else {
            throw new BookException("A book with this title already exists");
        }
    }

    public void updateBook(BookDto bookDto) {
        this.bookRepository.save(BookMapper.dtoToEntity(bookDto));
    }

    public void deleteBook(BookDto bookDto) {
        this.bookRepository.delete(BookMapper.dtoToEntity(bookDto));
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }


}
