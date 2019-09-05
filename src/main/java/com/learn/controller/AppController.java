package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    // localhost:8080/
    @RequestMapping("/")
    public String getHelloPage(Model model) {
        model.addAttribute("name", "world!");
        return "hello";
    }
}
