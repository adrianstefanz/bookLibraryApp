package com.example.bookLibraryApp.ThymeleafControllers;

import com.example.bookLibraryApp.dtos.BookDto;
import com.example.bookLibraryApp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddBookController {

    private final BookService bookService;

    public AddBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/add_book")
    public String showAddBookForm(Model model) {
        model.addAttribute("addBook", new BookDto());
        return "add_book";
    }

    @PostMapping("/add_book")
    public String addBook(@ModelAttribute BookDto book) {
        bookService.addNewBook(book);
        return "redirect:/book_library";
    }

}



