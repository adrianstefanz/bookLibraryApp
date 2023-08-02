package com.example.bookLibraryApp.ThymeleafControllers;


import com.example.bookLibraryApp.dtos.BookDto;
import com.example.bookLibraryApp.entities.Book;
import com.example.bookLibraryApp.services.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ShowBookController {


    private final BookService bookService;

    public ShowBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book_library/{id}")
    public String bookDetails(@PathVariable Long id, Model model) {
        BookDto bookDto = bookService.getBookById(id);
        if (bookDto != null) {
            model.addAttribute("book", bookDto);
            return "book_details";
        } else {
            return "redirect:/book_library";
        }
    }
}