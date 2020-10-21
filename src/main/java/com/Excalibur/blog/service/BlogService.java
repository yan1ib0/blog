package com.Excalibur.blog.service;

import com.Excalibur.blog.entity.Blog;
import com.github.pagehelper.PageInfo;

import java.util.List;
/*
 *  博客 Service
 *
 */

public interface BlogService {
    Integer addBlog(Blog blog);
    List<Blog> getAll();
    PageInfo<Blog> findCondition(Integer pageNum,Blog blog);
    PageInfo<Blog> getBlogPaging(Integer pageNum);
    Integer delBlog(Integer id);
    Blog getOneById(Integer id);
    Integer updateBlog(Blog blog);
    List<Blog> getBlogByColumnist(Integer columnId);
    List<Blog> getListByName(String name);
}
