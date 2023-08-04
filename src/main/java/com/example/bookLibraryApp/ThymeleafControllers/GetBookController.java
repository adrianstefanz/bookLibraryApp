package com.example.bookLibraryApp.ThymeleafControllers;

import com.example.bookLibraryApp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GetBookController {

    private final BookService bookService;

    public GetBookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/book_library")
    public String getBooks(Model model){
        model.addAttribute("books", bookService.getBooks());
        return "books";
    }


}
