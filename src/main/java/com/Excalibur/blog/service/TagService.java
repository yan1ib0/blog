package com.Excalibur.blog.service;

import com.Excalibur.blog.entity.Column;
import com.Excalibur.blog.entity.Tag;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
/*
 *  标签  Service
 *
 */
public interface TagService {
    List<Tag> getAll();

     PageInfo<Tag> getTagPaging(int i);

    Tag getTagById(Integer id);

    int addTag(Tag tag);

    int deleteTag(Integer id);

    void update(Tag tag);

    PageInfo<Tag> findCondition(Integer pageNum, Tag tag);
}
