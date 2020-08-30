package com.Excalibur.blog.dao;

import com.Excalibur.blog.entity.Comment;
import org.apache.ibatis.jdbc.SQL;

public class CommentSqlProvider {

    public String insertSelective(Comment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("comment");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getReplyName() != null) {
            sql.VALUES("reply_name", "#{replyName,jdbcType=VARCHAR}");
        }
        
        if (record.getReplyEmail() != null) {
            sql.VALUES("reply_email", "#{replyEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogId() != null) {
            sql.VALUES("blog_id", "#{blogId,jdbcType=INTEGER}");
        }
        
        if (record.getPublishDate() != null) {
            sql.VALUES("publish_date", "#{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuthorState() != null) {
            sql.VALUES("author_state", "#{authorState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyState() != null) {
            sql.VALUES("reply_state", "#{replyState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyContent() != null) {
            sql.VALUES("reply_content", "#{replyContent,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Comment record) {
        SQL sql = new SQL();
        sql.UPDATE("comment");
        
        if (record.getReplyName() != null) {
            sql.SET("reply_name = #{replyName,jdbcType=VARCHAR}");
        }
        
        if (record.getReplyEmail() != null) {
            sql.SET("reply_email = #{replyEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogId() != null) {
            sql.SET("blog_id = #{blogId,jdbcType=INTEGER}");
        }
        
        if (record.getPublishDate() != null) {
            sql.SET("publish_date = #{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuthorState() != null) {
            sql.SET("author_state = #{authorState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyState() != null) {
            sql.SET("reply_state = #{replyState,jdbcType=TINYINT}");
        }
        
        if (record.getReplyContent() != null) {
            sql.SET("reply_content = #{replyContent,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}