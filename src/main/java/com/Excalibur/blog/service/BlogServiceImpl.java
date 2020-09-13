package com.Excalibur.blog.service;

import com.Excalibur.blog.dao.BlogMapper;
import com.Excalibur.blog.entity.Blog;
import com.Excalibur.blog.entity.BlogExample;
import com.Excalibur.blog.entity.Column;
import com.Excalibur.blog.entity.ColumnExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    public Integer addBlog(Blog blog) {
        if (blog.getBlogState() == 1){
            //直接保存+发布
            blog.setPublishDate(new Date());
        }
        blog.setCreateTime(new Date());
        System.out.println(blog);

        return blogMapper.insert(blog);
    }

    public List<Blog> getAll() {
        Blog blog = new Blog();
        BlogExample blogExample = new BlogExample();
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        return blogs;
    }

    public PageInfo<Blog> findCondition(Integer pageNum,Blog blog) {
        PageHelper.startPage(pageNum,2);
        System.out.println(pageNum);
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria=blogExample.createCriteria();
        if(StringUtils.isNotBlank(blog.getTitle())){
            criteria.andTitleLike("%"+blog.getTitle()+"%");
        }
        if(StringUtils.isNotBlank(blog.getColumnId().toString())){
            criteria.andColumnIdEqualTo(blog.getColumnId());
        }
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        Iterator<Blog> it= blogs.iterator();
        PageInfo<Blog> pageInfo=new PageInfo<Blog>(blogs);
        return pageInfo;
    }

    public PageInfo<Blog> getBlogPaging() {
        PageHelper.startPage(1,2);
        Blog blog = new Blog();
        BlogExample blogExample = new BlogExample();
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        PageInfo<Blog> pageInfo=new PageInfo<Blog>(blogs);
        return pageInfo;
    }


}
