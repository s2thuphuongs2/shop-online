package com.example.shoponline.controller;

import com.example.shoponline.dto.api.ResponseDto;
import com.example.shoponline.dto.auth.input.LoginInput;
import com.example.shoponline.dto.auth.input.SignUpInput;
import com.example.shoponline.dto.auth.output.LoginOutput;
import com.example.shoponline.dto.auth.output.SignUpOutput;
import com.example.shoponline.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Controller dùng để quản lý việc đăng nhập, đăng kí, các api liên quan đến authen/author
 */
@Controller
//@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login-post")
//	public ResponseDto<LoginOutput> login(@RequestBody LoginInput input) {
//    public ResponseDto<LoginOutput> login(@ModelAttribute("loginInput") LoginInput input) {
    public RedirectView login(@ModelAttribute("loginInput") LoginInput input, Model model) {
        if (authService.login(input) != null)
            return new RedirectView("/home");
        else
            return new RedirectView("/login");
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("loginInput", new LoginInput());
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signUpInput", new SignUpInput());
        return "register";
    }

    @PostMapping("/signup-post")
//	public ResponseDto<SignUpOutput> signUp(@RequestBody SignUpInput input) {
//    public ResponseDto<SignUpOutput> signUp(@ModelAttribute("signUpInput") SignUpInput input) {
    public RedirectView signUp(@ModelAttribute("signUpInput") SignUpInput input, Model model) {
//        // Kiểm tra xác nhận mật khẩu ở đây nếu cần
//        if (!input.getPassword().equals(input.getConfirmPassword())) {
//            model.addAttribute("error", "Passwords do not match");
//            return "redirect:/signup"; // Đảm bảo bạn đã có trang signup.html
//        }
//        authService.signUp(input);
        if (authService.signUp(input) != null)
            return new RedirectView("/auth/login");
        else
            return new RedirectView("/auth/signup");
    }
//        return new RedirectView("/login");


}
