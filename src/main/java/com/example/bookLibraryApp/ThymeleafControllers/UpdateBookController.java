package com.example.bookLibraryApp.ThymeleafControllers;

import com.example.bookLibraryApp.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;

public class UpdateBookController {

    private final BookService bookService;

    public UpdateBookController(BookService bookService) {
        this.bookService = bookService;
    }


}
