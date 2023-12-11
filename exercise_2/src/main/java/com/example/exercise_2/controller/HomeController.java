package com.example.exercise_2.controller;

import com.example.exercise_2.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private IBookService bookService;

    @GetMapping({"/"})
    public String displayHomePage(Model model){


        model.addAttribute("isSort", false);
        model.addAttribute("books", bookService.getBookList(true));
        return "home";
    }

    @GetMapping({"/book"})
    public String sort(@RequestParam(value = "sort") String sort, Model model){
        boolean isSort = Boolean.parseBoolean(sort);

        model.addAttribute("isSort", !isSort);
        model.addAttribute("books", bookService.getBookList(!isSort));
        return "home";
    }
}
