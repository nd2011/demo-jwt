package com.example.demo.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello() {
        return "Xin chào, bạn đã vào được endpoint bảo vệ!";
    }
}
