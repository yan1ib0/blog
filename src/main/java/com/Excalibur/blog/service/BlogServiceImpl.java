package com.Excalibur.blog.service;

import com.Excalibur.blog.dao.BlogMapper;
import com.Excalibur.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    public Integer addBlog(Blog blog) {
        blog.setCreateTime(new Date());

        System.out.println(blog);

        return blogMapper.insert(blog);
    }
}
