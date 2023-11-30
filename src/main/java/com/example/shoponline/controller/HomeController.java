package com.example.shoponline.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
//@RequestMapping("/")
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "home";
    }
}
