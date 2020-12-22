package com.Excalibur.blog.service;

import com.Excalibur.blog.dao.ColumnMapper;
import com.Excalibur.blog.entity.Column;
import com.Excalibur.blog.entity.ColumnExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

import java.util.List;

@Service
public class ColumnServiceImpl implements ColumnService {
    @Autowired  //分类
            ColumnMapper columnMapper;

    public List<Column> getAll() {
        Column column = new Column();
        ColumnExample columnExample = new ColumnExample();
        List<Column> columns = columnMapper.selectByExample(columnExample);
        return columns;
    }

    public Column getColumnById(Integer id) {
        return columnMapper.selectByPrimaryKey(id);
    }

    public PageInfo<Column> findCondition(Integer pageNum, Column column) {
        PageHelper.startPage(pageNum, 5);
        System.out.println("请求 分类(专栏) 第" + pageNum + "页");
        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.createCriteria();
        if (StringUtils.isNotBlank(column.getName())) {
            criteria.andNameLike("%" + column.getName() + "%");
        }
        List<Column> columns = columnMapper.selectByExample(columnExample);
        PageInfo<Column> pageInfo = new PageInfo<Column>(columns);

        return pageInfo;
    }

    public PageInfo<Column> getColumnPaging(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        PageInfo<Column> pageInfo = new PageInfo<Column>(this.getAll());

        return pageInfo;
    }

    public Integer updateBlogCount(Column column) {
        return columnMapper.updateByPrimaryKey(column);
    }

    public Integer update(Column column) {

        return columnMapper.updateByPrimaryKey(column);
    }

    public int addBlog(Column column) {

        column.setBlogCount(0);
        column.setCreateTime(new Date());



        return columnMapper.insert(column);
    }

    public int deleteColumn(Integer id) {
        if(columnMapper.selectByPrimaryKey(id).getBlogCount()>0)
            return 0;
        return columnMapper.deleteByPrimaryKey(id);
    }
}
