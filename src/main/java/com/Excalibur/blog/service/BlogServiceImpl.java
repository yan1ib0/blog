package com.Excalibur.blog.service;

import com.Excalibur.blog.dao.BlogMapper;
import com.Excalibur.blog.entity.Blog;
import com.Excalibur.blog.entity.BlogExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Transactional
    public Integer addBlog(Blog blog) {
        if (blog.getBlogState() == 1) {
            //直接保存+发布
            blog.setPublishDate(new Date());
        }
        blog.setCreateTime(new Date());
        System.out.println(blog);

        return blogMapper.insert(blog);
    }

    public List<Blog> getAll(){

        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria=blogExample.createCriteria();
        criteria.andBlogStateEqualTo((byte)1);
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        return blogs;
    }

    public PageInfo<Blog> findCondition(Integer pageNum, Blog blog) {
        PageHelper.clearPage();
        PageHelper.startPage(pageNum, 5);
        System.out.println("第" + pageNum + "页");
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();

            if (StringUtils.isNotBlank(blog.getTitle())) {
                criteria.andTitleLike("%" + blog.getTitle() + "%");
            }
            if (StringUtils.isNotBlank(blog.getColumnId() == null ? "" : blog.getColumnId().toString())) {
                criteria.andColumnIdEqualTo(blog.getColumnId());
            }
            if (StringUtils.isNotBlank(blog.getBlogState() == null ? "" : blog.getBlogState().toString()))
                criteria.andBlogStateEqualTo((byte)1);

        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogs);
        return pageInfo;
    }


    public PageInfo<Blog> getBlogPaging(Integer pageNum) {
        PageHelper.clearPage();
        PageHelper.startPage(pageNum, 5);
        BlogExample blogExample = new BlogExample();
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogs);
        return pageInfo;
    }

    public Integer delBlog(Integer id) {

        Blog blog = blogMapper.selectByPrimaryKey(id);
        blog.setBlogState((byte)-1);
        return blogMapper.updateByPrimaryKey(blog);
    }

    public Blog getOneById(Integer id) {
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        if (StringUtils.isNotBlank(id.toString()))
            criteria.andIdEqualTo(id);
        List<Blog> blogs = blogMapper.selectByExampleWithBLOBs(blogExample);
        return blogs.get(0);
    }

    public Integer updateBlog(Blog blog) {
        return blogMapper.updateByPrimaryKey(blog);
    }

    public List<Blog> getBlogByColumnist(Integer columnId) {
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        if (StringUtils.isNotBlank(columnId.toString())) {
            criteria.andColumnIdEqualTo(columnId);
            criteria.andBlogStateEqualTo((byte)1);
        }
        List<Blog> blogs = blogMapper.selectByExampleWithBLOBs(blogExample);
        return blogs;
    }

    public List<Blog> getListByName(String name) {
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        if (StringUtils.isNotBlank(name)) {
            criteria.andTitleEqualTo(name);
        }
        List<Blog> blogs = blogMapper.selectByExampleWithBLOBs(blogExample);
        return blogs;
    }


}
