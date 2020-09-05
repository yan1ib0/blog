package com.Excalibur.blog.service;

import com.Excalibur.blog.dao.TagMapper;
import com.Excalibur.blog.entity.Tag;
import com.Excalibur.blog.entity.TagExample;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;
    public List<Tag> getAll() {
        Tag tag=new Tag();
        tag.setBlogCount("1");
        TagExample tagExample=new TagExample();
        TagExample.Criteria criteria=tagExample.createCriteria();
        if(StringUtils.isNotBlank(tag.getBlogCount())){
            criteria.andBlogCountEqualTo(tag.getBlogCount());
        }
        List<Tag> tags = tagMapper.selectByExample(tagExample);
        return tags;
    }
}
