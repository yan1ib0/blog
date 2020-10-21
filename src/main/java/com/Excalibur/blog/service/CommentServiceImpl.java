package com.Excalibur.blog.service;

import com.Excalibur.blog.dao.CommentMapper;
import com.Excalibur.blog.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    BlogService blogService;

    public List<Comment> getAll() {
        CommentExample commentExample = new CommentExample();
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return comments;
    }

    public int addComment(Comment comment) {
        comment.setCreateTime(new Date().toString());
        return commentMapper.insert(comment);
    }

    public Comment getCommentById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    public PageInfo<Comment> findCondition(int pageNum, String name) {
        Blog blog = new Blog();
        if (name == "" || name==null)
            return this.getCommentPaging(1);
        blog.setTitle(name);

        List<Blog> blogs = blogService.findCondition(1, blog).getList();



        PageHelper.startPage(pageNum, 5);
        System.out.println("请求 评论 第" + pageNum + "页");
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        for (Blog b : blogs) {
            criteria.andBlogIdEqualTo(b.getId());
        }
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(comments);
        return pageInfo;
    }

    public PageInfo<Comment> getCommentPaging(int pageNum) {
        return new PageInfo<Comment>(this.getAll());
    }

    public int delete(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    public int update(Comment comment) {
        return commentMapper.updateByPrimaryKey(comment);
    }
}
