package com.Excalibur.blog.service;

import com.Excalibur.blog.dao.ColumnMapper;
import com.Excalibur.blog.entity.Column;
import com.Excalibur.blog.entity.ColumnExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
@Service
public class ColumnServiceImpl implements ColumnService {
    @Autowired  //分类
    ColumnMapper columnMapper;

    public List<Column> getAll() {
        Column column=new Column();
        ColumnExample columnExample=new ColumnExample();
        List<Column> columns=columnMapper.selectByExample(columnExample);
        return columns;
    }
}
