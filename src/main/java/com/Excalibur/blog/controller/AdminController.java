package com.Excalibur.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }
}
