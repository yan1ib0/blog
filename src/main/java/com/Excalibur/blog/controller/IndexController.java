package com.Excalibur.blog.controller;

import cn.hutool.core.date.DateUtil;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.MarkdownUtil;

import java.util.*;


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

    @GetMapping("/blogPage/{id}")
    public String blogPage(@PathVariable Integer id,Model model){
        Blog blog= blogService.getOneById(id);
        model.addAttribute("blog",blog);
        String[] strs=blog.getTags().split(",");
        List<Tag> tags=new ArrayList<>();
        for (String s:strs) {
            tags.add(tagService.getTagById(Integer.parseInt(s)));
        }
        model.addAttribute("tags",tags);
        model.addAttribute("column",columnService.getColumnById(blog.getColumnId()));
        model.addAttribute("content",MarkdownUtil.markdownToHtmlExtens(blog.getContent()));
        return "blog";
    }

    @GetMapping("/columnistPage")
    public String columnistPage(Model model){
        model.addAttribute("columns",columnService.getColumnPaging(1));
        model.addAttribute("blogList",new PageInfo<Blog>( blogService.getBlogByColumnist(1)));
        return "columnist";
    }
    @GetMapping("/tagPage")
    public String tagPage(Model model){
        model.addAttribute("tags",tagService.getTagPaging(1));
        model.addAttribute("blogList",blogService.getBlogPaging(1));
        return "tags";
    }

    @GetMapping("/archives")
    public  String archivesPage(Model model){
        PageInfo<Blog> pageInfo=blogService.getBlogPaging(1);
        model.addAttribute("number",pageInfo.getTotal());
        HashMap<Integer,List<Blog>> years=new HashMap<Integer, List<Blog>>();
        List<Blog> list=pageInfo.getList();
        for (Blog b:list) {
            Date blogdate=b.getCreateTime();
            int year = DateUtil.year(blogdate);
            if (years.get(year)==null){
                List<Blog> blogs=new ArrayList<Blog>();
                blogs.add(b);
                years.put(year,blogs);
            }
            List<Blog> blogs=years.get(year);
            blogs.add(b);
            years.put(year,blogs);
        }
        model.addAttribute("years",years);

        return "archives";
    }


}
