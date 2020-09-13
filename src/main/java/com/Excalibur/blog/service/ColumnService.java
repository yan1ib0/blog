package com.Excalibur.blog.service;

import com.Excalibur.blog.entity.Column;

import java.util.List;

public interface ColumnService {
    List<Column> getAll();
    Column getColumnById(Integer id);
}
