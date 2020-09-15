package com.Excalibur.blog.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.*;


@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired      //分类
            ColumnService columnService;

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    //主页
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("tags", tagService.getAll());
        model.addAttribute("pageInfo", blogService.getBlogPaging(1));
        return "admin/manage";
    }

    //跳转 <增加页面>
    @GetMapping("/blogAddPage")
    public String blogAdd(Model model) {
        List<Column> columns = columnService.getAll();
        model.addAttribute("columns", columns);
        List<Tag> tags = tagService.getAll();
        model.addAttribute("tags", tags);
        return "/admin/blog_add";
    }

    //跳转 <修改页面>
    @GetMapping("/editBlogPage/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        System.out.println(id);
        Blog blog = blogService.getOneById(id);
        model.addAttribute("blog", blog);
        PageInfo<Blog> pageInfo = blogService.getBlogPaging(1);
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("tags",tagService.getAll());
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("content",new  String(blog.getContent()));
        return "/admin/blog_edit";
    }

    // 增
    @PostMapping("/blogAdd")
    public String blogAdd(Blog blog) {
        int code = blogService.addBlog(blog);
        if (code < 1) {
            System.err.println("添加失败");
        }
        System.out.println("<<<< :: 插入博客成功 :: >>>>  " + code);
        return "redirect:/admin/index";
    }

    //删
    @DeleteMapping("/delBlog")
    public String DeleteBlog(@RequestParam Integer id, Model model) {
        int code = blogService.delBlog(id);
        PageInfo<Blog> pageInfo = blogService.getBlogPaging(1);
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/manage::table_refresh";
    }

    //改
    @PostMapping("/blogUpdate")
    public String update(Blog blog,Model model){
        blogService.updateBlog(blog);
        PageInfo<Blog> pageInfo = blogService.getBlogPaging(1);
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/manage::table_refresh";
    }
    //查 <按条件>
    @PostMapping("/findCondition")
    public String search(Integer pageNum, Blog blog, Model model) {
        PageInfo<Blog> pageInfo = blogService.findCondition(pageNum, blog);
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/manage::table_refresh";
    }


}
