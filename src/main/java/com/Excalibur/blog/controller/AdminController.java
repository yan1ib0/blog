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

    //跳转           主页
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("tags", tagService.getAll());
        model.addAttribute("pageInfo", blogService.getBlogPaging(1));
        return "admin/manage";
    }



    /*
     *  分类 (专栏)  部分
     *
     *
     */


    //跳转        <分类   页面>
    @GetMapping("columnistPage")
    public String ColumnistPage(Model model) {
        model.addAttribute("pageInfo", columnService.getColumnPaging(1));
        return "admin/columnist";
    }

    //跳转        <增加 分类(专栏)  页面>
    @GetMapping("columnistAddPage")
    public String ColumnistAddPage() {
        return "admin/columnist_add";
    }

    @GetMapping("/editColumnist/{id}")
    public String editColumnPage(@PathVariable Integer id, Model model) {
        Column column = columnService.getColumnById(id);
        model.addAttribute("col", column);
        PageInfo<Column> pageInfo = columnService.getColumnPaging(1);
        model.addAttribute("pageInfo", pageInfo);
        return "/admin/columnist_edit";
    }

    //增加          分类 (专栏)
    @PostMapping("/columnistAdd")
    public String columnistAdd(Column column) {
        int code = columnService.addBlog(column);
        if (code < 1) {
            System.err.println("<<<< :: 添加专栏失败 :: >>>>");
        }
        System.out.println("<<<< :: 插入专栏成功 :: >>>>  " + code);

        return "redirect:/admin/columnistPage";
    }


    //删除           分类(专栏)
    @DeleteMapping("/delColumnist")
    public String DeleteColumnist(@RequestParam Integer id, Model model) {
        int code = columnService.deleteColumn(id);
        PageInfo<Column> pageInfo = columnService.getColumnPaging(1);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/columnist::table_refresh";
    }


    //修改            分类 (专栏)
    @PostMapping("/columnistUpdate")
    public String Columnist(Column column, Model model) {
        columnService.update(column);
        PageInfo<Column> pageInfo = columnService.getColumnPaging(1);
        model.addAttribute("pageInfo",pageInfo);

        return "admin/columnist";

    }

    //按条件查 分类(专栏) findConditionByColumnist
    @GetMapping("/findConditionByColumnist")
    public String findConditionByColumnist(Integer pageNum, Column c, Model model) {
        PageInfo<Column> pageInfo = columnService.findCondition(pageNum, c);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/columnist::table_refresh";
    }


    /*
     *                  博客    部分
     *
     */


    //跳转        <博客增加页面>
    @GetMapping("/blogAddPage")
    public String blogAdd(Model model) {
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("tags", tagService.getAll());
        return "/admin/blog_add";
    }

    //跳转         <博客修改页面>
    @GetMapping("/editBlogPage/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        System.out.println(id);
        Blog blog = blogService.getOneById(id);
        model.addAttribute("blog", blog);
        PageInfo<Blog> pageInfo = blogService.getBlogPaging(1);
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("tags", tagService.getAll());
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("content", new String(blog.getContent()));
        return "/admin/blog_edit";
    }



    //增加          博客
    @PostMapping("/blogAdd")
    public String blogAdd(Blog blog) {
        int code = blogService.addBlog(blog);
        if (code < 1) {
            System.err.println("添加失败");
        }

        System.out.println("<<<< :: 插入博客成功 :: >>>>  " + code);
        //更新博客数
        int count = blogService.getBlogByColumnist(blog.getColumnId()).size();
        Column column = columnService.getColumnById(blog.getColumnId());
        column.setBlogCount(count);
        columnService.updateBlogCount(column);

        return "redirect:/admin/index";
    }

    //删除           博客
    @DeleteMapping("/delBlog")
    public String DeleteBlog(@RequestParam Integer id, Model model) {
        int code = blogService.delBlog(id);
        PageInfo<Blog> pageInfo = blogService.getBlogPaging(1);
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("pageInfo", pageInfo);

        //更新博客数
        int count = blogService.getBlogByColumnist(blogService.getOneById(id).getColumnId()).size();
        Column column = columnService.getColumnById(blogService.getOneById(id).getColumnId());
        column.setBlogCount(count);
        columnService.updateBlogCount(column);

        return "admin/manage::table_refresh";
    }

    //修改            博客
    @PostMapping("/blogUpdate")
    public String update(Blog blog, Model model) {
        blogService.updateBlog(blog);
        PageInfo<Blog> pageInfo = blogService.getBlogPaging(1);
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("pageInfo", pageInfo);

        //更新博客数
        int count = blogService.getBlogByColumnist(blog.getColumnId()).size();
        Column column = columnService.getColumnById(blog.getColumnId());
        column.setBlogCount(count);
        columnService.updateBlogCount(column);


        return "admin/manage";
    }

    //查             <按条件  博客>
    @PostMapping("/findCondition")
    public String search(Integer pageNum, Blog blog, Model model) {
        PageInfo<Blog> pageInfo = blogService.findCondition(pageNum, blog);
        model.addAttribute("columns", columnService.getAll());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/manage::table_refresh";
    }

    @GetMapping("/blogs")
    public String bs() {
        return "redirect:/admin/index";
    }


}
