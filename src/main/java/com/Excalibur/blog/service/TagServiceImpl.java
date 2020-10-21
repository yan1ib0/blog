package com.Excalibur.blog.service;

import com.Excalibur.blog.dao.TagMapper;
import com.Excalibur.blog.entity.Column;
import com.Excalibur.blog.entity.ColumnExample;
import com.Excalibur.blog.entity.Tag;
import com.Excalibur.blog.entity.TagExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;
    public List<Tag> getAll() {
        TagExample tagExample=new TagExample();
        List<Tag> tags = tagMapper.selectByExample(tagExample);
        return tags;
    }

    public PageInfo<Tag> getTagPaging(int i) {
        PageHelper.startPage(1,5);
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(this.getAll());
        return pageInfo;
    }

    public Tag getTagById(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    public int addTag(Tag tag) {
        tag.setCreateTime(new Date());
        tag.setBlogCount("1");
        return tagMapper.insert(tag);
    }

    public int deleteTag(Integer id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

    public void update(Tag tag) {
        tagMapper.updateByPrimaryKey(tag);
    }

    public PageInfo<Tag> findCondition(Integer pageNum, Tag tag) {
        PageHelper.startPage(pageNum, 5);
        System.out.println("请求 标签 第" + pageNum + "页");
        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        if (StringUtils.isNotBlank(tag.getName())) {
            criteria.andNameLike("%" + tag.getName() + "%");
        }
        List<Tag> tags = tagMapper.selectByExample(tagExample);
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(tags);

        return pageInfo;
    }
}
