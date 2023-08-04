package com.example.bookLibraryApp.ThymeleafControllers;

import com.example.bookLibraryApp.dtos.UserReviewDto;
import com.example.bookLibraryApp.entities.UserReview;
import com.example.bookLibraryApp.services.BookService;
import com.example.bookLibraryApp.services.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddReviewController {

    @Autowired
    private final UserReviewService userReviewService;
    @Autowired
    private final BookService bookService;


    public AddReviewController(UserReviewService userReviewService, BookService bookService) {
        this.userReviewService = userReviewService;
        this.bookService = bookService;
    }

//@GetMapping("/add_review")
//public String showAddReviewForm(Model model) {
//    model.addAttribute("addReview", new UserReviewDto());
//    return "add_review";

    @GetMapping("/book_library/{Id}/add_review")
    public String showReviewForm(@PathVariable Long id, Model model) {
        model.addAttribute("bookId", bookService.getBookById(id));
        model.addAttribute("review", new UserReviewDto());
        return "book_details";
    }


    @PostMapping("/book_library/{id}")
    public String addReview(@ModelAttribute UserReviewDto userReview) {
        userReviewService.addNewReview(userReview);
        return "redirect:/book_details";
    }
}
