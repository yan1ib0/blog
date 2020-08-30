package com.Excalibur.blog.dao;

import com.Excalibur.blog.entity.Tag;
import org.apache.ibatis.jdbc.SQL;

public class TagSqlProvider {

    public String insertSelective(Tag record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tag");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogCount() != null) {
            sql.VALUES("blog_count", "#{blogCount,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Tag record) {
        SQL sql = new SQL();
        sql.UPDATE("tag");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogCount() != null) {
            sql.SET("blog_count = #{blogCount,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}