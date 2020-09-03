package com.Excalibur.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String testIndex(){
        return "test";
    }
    @GetMapping("/login")
    public String Login(){
        return "admin/login";
    }
    @GetMapping("/index")
    public String index(){
        return "admin/manage";
    }

}
