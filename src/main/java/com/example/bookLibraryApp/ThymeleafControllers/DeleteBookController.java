package com.example.bookLibraryApp.ThymeleafControllers;

import com.example.bookLibraryApp.dtos.BookDto;
import com.example.bookLibraryApp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteBookController {

    private final BookService bookService;

    public DeleteBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book_library/{title}")
    public String showBookDetails(@PathVariable String title, Model model) {
    BookDto bookDto = bookService.getBookByTitle(title);
        if (bookDto != null) {
        model.addAttribute("book", bookDto);
        return "book_details";
    } else {
        return "redirect:/book_library";
    }
}

    @PostMapping("/book_library/{title}/delete")
    public String deleteBook(@PathVariable String title) {
        BookDto bookDto = bookService.getBookByTitle(title);
        if (bookDto != null) {
           bookService.deleteBook(bookDto);
        }
        return "redirect:/book_library";
    }


}