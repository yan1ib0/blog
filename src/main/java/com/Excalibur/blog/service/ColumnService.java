package com.Excalibur.blog.service;

import com.Excalibur.blog.entity.Blog;
import com.Excalibur.blog.entity.Column;
import com.github.pagehelper.PageInfo;

import java.util.List;

/*
 *  分类(专栏) Service
 *
 */
public interface ColumnService {

    List<Column> getAll();

    Column getColumnById(Integer id);

    PageInfo<Column> findCondition(Integer pageNum, Column column);

    PageInfo<Column> getColumnPaging(Integer pageNum);

    Integer updateBlogCount(Column column);

    Integer update(Column column);

    int addBlog(Column column);

    int deleteColumn(Integer id);
}
