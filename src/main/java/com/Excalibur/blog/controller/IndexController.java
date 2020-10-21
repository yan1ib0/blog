package com.Excalibur.blog.controller;

import com.Excalibur.blog.entity.Blog;
import com.Excalibur.blog.entity.Column;
import com.Excalibur.blog.service.BlogService;
import com.Excalibur.blog.service.ColumnService;
import com.Excalibur.blog.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



@Controller
public class IndexController {
    @Autowired      //分类
    ColumnService columnService;

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;


    @GetMapping("/test")
    public String testIndex() {
        return "test";
    }

    @GetMapping("/login")
    public String Login() {
        return "admin/login";
    }

    @GetMapping("/index")
    public String Index(Model model) {
        Blog blog=new Blog();
        blog.setBlogState((byte)1);
        PageInfo<Blog> blogPageInfo=blogService.findCondition(1,blog);
        model.addAttribute("columns",columnService.getAll());
        model.addAttribute("pageInfo",blogPageInfo);
        return "index";
    }
    @GetMapping("/")
    public String index(Model model) {
        Blog blog=new Blog();
        blog.setBlogState((byte)1);
        PageInfo<Blog> blogPageInfo=blogService.findCondition(1,blog);
        model.addAttribute("columns",columnService.getAll());
        model.addAttribute("pageInfo",blogPageInfo);
        return "index";
    }
    @GetMapping("/About")
    public String About(){
        return "about";
    }

    @PostMapping("/findAll")
    public String show(Integer pageNum, Model model) {
        Blog blog=new Blog();
        blog.setBlogState((byte)1);
        PageInfo<Blog> blogPageInfo=blogService.findCondition(1,blog);
        model.addAttribute("columns",columnService.getAll());
        model.addAttribute("pageInfo",blogPageInfo);
        return "index::table_refresh";
    }
}
