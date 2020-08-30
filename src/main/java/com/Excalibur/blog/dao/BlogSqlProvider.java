package com.Excalibur.blog.dao;

import com.Excalibur.blog.entity.Blog;
import org.apache.ibatis.jdbc.SQL;

public class BlogSqlProvider {

    public String insertSelective(Blog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("blog_content");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSummary() != null) {
            sql.VALUES("summary", "#{summary,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishDate() != null) {
            sql.VALUES("publish_date", "#{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getColumnId() != null) {
            sql.VALUES("column_id", "#{columnId,jdbcType=INTEGER}");
        }
        
        if (record.getViews() != null) {
            sql.VALUES("views", "#{views,jdbcType=INTEGER}");
        }
        
        if (record.getTags() != null) {
            sql.VALUES("tags", "#{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getComments() != null) {
            sql.VALUES("comments", "#{comments,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogImgs() != null) {
            sql.VALUES("blog_imgs", "#{blogImgs,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogState() != null) {
            sql.VALUES("blog_state", "#{blogState,jdbcType=TINYINT}");
        }
        
        if (record.getAdmireState() != null) {
            sql.VALUES("admire_state", "#{admireState,jdbcType=TINYINT}");
        }
        
        if (record.getCommentsState() != null) {
            sql.VALUES("comments_state", "#{commentsState,jdbcType=TINYINT}");
        }
        
        if (record.getRecommendState() != null) {
            sql.VALUES("recommend_state", "#{recommendState,jdbcType=TINYINT}");
        }
        
        if (record.getReprintState() != null) {
            sql.VALUES("reprint_state", "#{reprintState,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARBINARY}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Blog record) {
        SQL sql = new SQL();
        sql.UPDATE("blog_content");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSummary() != null) {
            sql.SET("summary = #{summary,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishDate() != null) {
            sql.SET("publish_date = #{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getColumnId() != null) {
            sql.SET("column_id = #{columnId,jdbcType=INTEGER}");
        }
        
        if (record.getViews() != null) {
            sql.SET("views = #{views,jdbcType=INTEGER}");
        }
        
        if (record.getTags() != null) {
            sql.SET("tags = #{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getComments() != null) {
            sql.SET("comments = #{comments,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogImgs() != null) {
            sql.SET("blog_imgs = #{blogImgs,jdbcType=VARCHAR}");
        }
        
        if (record.getBlogState() != null) {
            sql.SET("blog_state = #{blogState,jdbcType=TINYINT}");
        }
        
        if (record.getAdmireState() != null) {
            sql.SET("admire_state = #{admireState,jdbcType=TINYINT}");
        }
        
        if (record.getCommentsState() != null) {
            sql.SET("comments_state = #{commentsState,jdbcType=TINYINT}");
        }
        
        if (record.getRecommendState() != null) {
            sql.SET("recommend_state = #{recommendState,jdbcType=TINYINT}");
        }
        
        if (record.getReprintState() != null) {
            sql.SET("reprint_state = #{reprintState,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARBINARY}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}