package com.example.bookLibraryApp.ThymeleafControllers;


import com.example.bookLibraryApp.dtos.BookDto;
import com.example.bookLibraryApp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class BookDetailsController {

    private final BookService bookService;

    public BookDetailsController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book_library/{id}")
    public String showBookDetails(@PathVariable Long id, Model model) {
        BookDto bookDto = bookService.getBookById(id);
        model.addAttribute("bookDetails", bookDto);
        return "book_details";
    }

}