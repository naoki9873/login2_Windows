package com.example.login2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.login2.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;  // ← ここに書く！

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register") //ここが登録するところ
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {
        userService.registerUser(username, password); // ← ここで呼べるようになる
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
