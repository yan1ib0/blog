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
public class TestController {
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
        List<Blog> blogs=blogService.getAll();
        List<Column> columns =new ArrayList<Column>();
        PageInfo<Blog> blogPageInfo=blogService.getBlogPaging();
        Iterator<Blog> it=blogPageInfo.getList().iterator();
        while(it.hasNext()){
            Column column=columnService.getColumnById(it.next().getColumnId());
            columns.add(column);
        }
        model.addAttribute("columns",columns);
        model.addAttribute("blogs",blogs);
        model.addAttribute("pageInfo",blogPageInfo);
        return "index";
    }
    @ResponseBody
    @PostMapping("/ad")
    public String getColumn(Integer id){
        Column column=columnService.getColumnById(id);
        System.out.println(column.getName());
        return column.getName();
    }

}
