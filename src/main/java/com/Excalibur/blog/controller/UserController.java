package com.Excalibur.blog.controller;

import com.Excalibur.blog.entity.User;
import com.Excalibur.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public String login(String name, String password, HttpSession session, Model model){
        User user=userService.login(name,password);

        if (user == null){
            model.addAttribute("tip","账号或密码不正确");
            return "admin/login";
        }
        session.setAttribute("user",user);
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }
}
