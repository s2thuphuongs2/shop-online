package com.example.shoponline.controller;


import com.example.shoponline.dto.ProductDTO;
import com.example.shoponline.entity.Product;
import com.example.shoponline.service.CartService;
import com.example.shoponline.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductService productService; // Giả sử ProductService đã được triển khai
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String home(Model model) {
        // Lấy danh sách sản phẩm từ service
        List<? extends Product> laptopProducts = productService.getProducts("LAPTOP");

        // Đặt danh sách sản phẩm vào model để Thymeleaf có thể sử dụng
        model.addAttribute("products", laptopProducts);

        List<? extends Product> mobileProducts = productService.getProducts("MOBILE");
        model.addAttribute("mobileProducts", mobileProducts);

        List<? extends Product> monitorProducts = productService.getProducts("MONITOR");
        model.addAttribute("monitorProducts", monitorProducts);


        // Trả về tên trang HTML
        return "home";
    }
}
