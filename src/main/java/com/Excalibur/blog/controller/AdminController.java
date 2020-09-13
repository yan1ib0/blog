package com.Excalibur.blog.controller;

import com.Excalibur.blog.entity.Blog;
import com.Excalibur.blog.entity.Column;
import com.Excalibur.blog.entity.Tag;
import com.Excalibur.blog.service.BlogService;
import com.Excalibur.blog.service.ColumnService;
import com.Excalibur.blog.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

    @RequestMapping("/admin")
    @Controller
    public class AdminController {

        @Autowired      //分类
        ColumnService columnService;

        @Autowired
        TagService tagService;

        @Autowired
        BlogService blogService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("columns",columnService.getAll());
        model.addAttribute("tags",tagService.getAll());
        model.addAttribute("pageInfo",blogService.getBlogPaging());
        return "admin/manage";
    }

    @GetMapping("/blogAddPage")
    public String blogAdd(Model model) {
        List<Column> columns = columnService.getAll();
        model.addAttribute("columns", columns);
        List<Tag> tags = tagService.getAll();
        model.addAttribute("tags", tags);
        return "/admin/blog_add";
    }

    @PostMapping("/blogAdd")
    public String blogAdd(Blog blog) {
       int code= blogService.addBlog(blog);
       if (code<1){
           System.err.println("添加失败");
       }
        System.out.println("<<<< :: 插入博客成功 :: >>>>  "+code);
        return "redirect:/admin/index";
    }

    @PostMapping("/findCondition")
    public String search(Integer pageNum,Blog blog,Model model){
        PageInfo<Blog> pageInfo=blogService.findCondition(pageNum,blog);
        model.addAttribute("pageInfo",pageInfo);
            return "admin/manage::table_refresh";
    }
}
