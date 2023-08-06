package com.example.bookLibraryApp.ThymeleafControllers;


import com.example.bookLibraryApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteBookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/delete_book")
    public String showDeleteBookForm() {
        return "delete_book";
    }

    @PostMapping("/book_library/delete")
    public String deleteBook(@RequestParam("id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/book_library";
    }
}
