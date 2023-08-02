package com.example.bookLibraryApp.controllers;


import com.example.bookLibraryApp.dtos.BookDto;
import com.example.bookLibraryApp.exceptions.BookException;
import com.example.bookLibraryApp.services.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping(path = "/{title}")
    public BookDto getBookByTitle(@PathVariable(value = "title") String title) {
        return bookService.getBookByTitle(title);
    }

    // Method to list all books from the Book Library


    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks(@NotNull Model model) {
        model.addAttribute("books", bookService.getBooks());
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);


    }

//    @GetMapping(path = "/books")
//    public String getBooks(Model model){
//        model.addAttribute("books", bookService.getBooks());
//        return "bookList";
//    }

    // Method to add a new book to the Book Library

    @PostMapping
    public ResponseEntity<String> addNewBook(@RequestBody BookDto bookDto) {

        try {
            bookService.addNewBook(bookDto);
            return new ResponseEntity<>("Book with title: " + bookDto.getTitle() + " added to the library.", HttpStatus.CREATED);
        } catch (BookException e) {
            return new ResponseEntity<>("Exception in adding book with title: " + bookDto.getTitle() + "." + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Method to update a book from the Book Library

    @PostMapping(path = "/update")
    public ResponseEntity<String> updateBook(@RequestBody BookDto bookDto) {
        try {
            bookService.updateBook(bookDto);
            return new ResponseEntity<>("Book with title " + bookDto.getTitle() + " updated", HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>("Exception in updating book with title: " + bookDto.getTitle() + "." + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Method to delete a book from the Book Library by

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteBook(@RequestBody BookDto bookDto) {
        try {
            bookService.deleteBook(bookDto);
            return new ResponseEntity<>("Book with title " + bookDto.getTitle() + " deleted", HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>("Exception in removing book with title: " + bookDto.getTitle() + "." + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
