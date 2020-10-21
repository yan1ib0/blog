package com.Excalibur.blog.service;

import com.Excalibur.blog.entity.Comment;
import com.Excalibur.blog.entity.Tag;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {

    List<Comment> getAll();

    int addComment(Comment comment);

    Comment getCommentById(Integer id);

    PageInfo<Comment> findCondition(int pageNum, String name);

    PageInfo<Comment> getCommentPaging(int pageNum);

    int delete(Integer id);

    int update(Comment comment);
}
