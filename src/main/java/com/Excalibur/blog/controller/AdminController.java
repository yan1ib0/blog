package com.Excalibur.blog.controller;

import com.Excalibur.blog.dao.ColumnMapper;
import com.Excalibur.blog.entity.Blog;
import com.Excalibur.blog.entity.Column;
import com.Excalibur.blog.entity.Tag;
import com.Excalibur.blog.service.BlogService;
import com.Excalibur.blog.service.ColumnService;
import com.Excalibur.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
        System.out.println("插入状态 :: >>>>  "+code);
        return "index";
    }

}
