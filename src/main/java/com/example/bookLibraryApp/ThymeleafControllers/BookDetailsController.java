package com.example.bookLibraryApp.ThymeleafControllers;


import com.example.bookLibraryApp.dtos.BookDto;
import com.example.bookLibraryApp.dtos.UserReviewDto;
import com.example.bookLibraryApp.entities.UserReview;
import com.example.bookLibraryApp.services.BookService;
import com.example.bookLibraryApp.services.UserReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookDetailsController {

    private final BookService bookService;
    private final UserReviewService userReviewService;

    public BookDetailsController(BookService bookService, UserReviewService userReviewService) {
        this.bookService = bookService;
        this.userReviewService = userReviewService;
    }

    // Endpoint to see the book details when you click on book id
    @GetMapping("/book_library/{id}")
    public String showBookDetails(@PathVariable Long id, Model model) {
        BookDto bookDto = bookService.getBookById(id);
        model.addAttribute("bookDetails", bookDto);
        return "book_details";
    }

    // Endpoint to show the update book form
    @GetMapping("/book_library/{id}/edit")
    public String showUpdateBookForm(@PathVariable Long id, Model model) {
        BookDto bookDto = bookService.getBookById(id);
        model.addAttribute("book", bookDto);
        return "update_book_form";
    }

    // Endpoint to process book updates
    @PostMapping("/book_library/{id}/update")
    public String updateBook(@PathVariable Long id, @ModelAttribute BookDto updatedBook) {
        BookDto bookDto = bookService.getBookById(id);
        bookDto.setTitle(updatedBook.getTitle());
        bookDto.setYearPublished(updatedBook.getYearPublished());
        bookService.addNewBook(bookDto);
        return "redirect:/book_library/" + id;
    }

// Add review

//    @GetMapping("book_library/{id}/addReview")
//    public String showReviewForm(@PathVariable("id") Long id, Model model) {
//        BookDto bookDto = bookService.getBookById(id);
//        model.addAttribute("book", bookDto);
//        model.addAttribute("userReview", new UserReview());
//        return "reviewForm";
//    }
//
//
//     @PostMapping("book_library/{id}/addReview")
//    public String addReview(@PathVariable("id") Long id, @ModelAttribute UserReviewDto userReviewDto) {
//        BookDto bookDto = bookService.getBookById(id);
//        userReviewDto.setReviewId(id);
//        userReviewDto.setReviewTitle(userReviewDto.getReviewTitle());
//        userReviewDto.setReviewText(userReviewDto.getReviewText());
//        userReviewService.addNewReview(userReviewDto);
//        return "redirect:/book_library/" + id;
//    }

}
