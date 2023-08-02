package com.example.bookLibraryApp.ThymeleafControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// IndexController.java
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

