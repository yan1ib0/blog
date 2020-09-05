package com.Excalibur.blog.dao;

import com.Excalibur.blog.entity.Blog;
import com.Excalibur.blog.entity.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogMapper {
    @SelectProvider(type=BlogSqlProvider.class, method="countByExample")
    long countByExample(BlogExample example);

    @Delete({
        "delete from blog_content",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into blog_content (id, title, ",
        "summary, publish_date, ",
        "column_id, views, ",
        "tags, comments, ",
        "blog_img, blog_state, ",
        "admire_state, comments_state, ",
        "recommend_state, reprint_state, ",
        "create_time, content)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{summary,jdbcType=VARCHAR}, #{publishDate,jdbcType=TIMESTAMP}, ",
        "#{columnId,jdbcType=INTEGER}, #{views,jdbcType=INTEGER}, ",
        "#{tags,jdbcType=VARCHAR}, #{comments,jdbcType=VARCHAR}, ",
        "#{blogImg,jdbcType=VARCHAR}, #{blogState,jdbcType=TINYINT}, ",
        "#{admireState,jdbcType=TINYINT}, #{commentsState,jdbcType=TINYINT}, ",
        "#{recommendState,jdbcType=TINYINT}, #{reprintState,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{content,jdbcType=LONGVARBINARY})"
    })
    int insert(Blog record);

    @InsertProvider(type=BlogSqlProvider.class, method="insertSelective")
    int insertSelective(Blog record);

    @SelectProvider(type=BlogSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_date", property="publishDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="column_id", property="columnId", jdbcType=JdbcType.INTEGER),
        @Result(column="views", property="views", jdbcType=JdbcType.INTEGER),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR),
        @Result(column="comments", property="comments", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_img", property="blogImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_state", property="blogState", jdbcType=JdbcType.TINYINT),
        @Result(column="admire_state", property="admireState", jdbcType=JdbcType.TINYINT),
        @Result(column="comments_state", property="commentsState", jdbcType=JdbcType.TINYINT),
        @Result(column="recommend_state", property="recommendState", jdbcType=JdbcType.TINYINT),
        @Result(column="reprint_state", property="reprintState", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    @SelectProvider(type=BlogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_date", property="publishDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="column_id", property="columnId", jdbcType=JdbcType.INTEGER),
        @Result(column="views", property="views", jdbcType=JdbcType.INTEGER),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR),
        @Result(column="comments", property="comments", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_img", property="blogImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_state", property="blogState", jdbcType=JdbcType.TINYINT),
        @Result(column="admire_state", property="admireState", jdbcType=JdbcType.TINYINT),
        @Result(column="comments_state", property="commentsState", jdbcType=JdbcType.TINYINT),
        @Result(column="recommend_state", property="recommendState", jdbcType=JdbcType.TINYINT),
        @Result(column="reprint_state", property="reprintState", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Blog> selectByExample(BlogExample example);

    @Select({
        "select",
        "id, title, summary, publish_date, column_id, views, tags, comments, blog_img, ",
        "blog_state, admire_state, comments_state, recommend_state, reprint_state, create_time, ",
        "content",
        "from blog_content",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_date", property="publishDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="column_id", property="columnId", jdbcType=JdbcType.INTEGER),
        @Result(column="views", property="views", jdbcType=JdbcType.INTEGER),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR),
        @Result(column="comments", property="comments", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_img", property="blogImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_state", property="blogState", jdbcType=JdbcType.TINYINT),
        @Result(column="admire_state", property="admireState", jdbcType=JdbcType.TINYINT),
        @Result(column="comments_state", property="commentsState", jdbcType=JdbcType.TINYINT),
        @Result(column="recommend_state", property="recommendState", jdbcType=JdbcType.TINYINT),
        @Result(column="reprint_state", property="reprintState", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARBINARY)
    })
    Blog selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BlogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    @UpdateProvider(type=BlogSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    @UpdateProvider(type=BlogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    @UpdateProvider(type=BlogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Blog record);

    @Update({
        "update blog_content",
        "set title = #{title,jdbcType=VARCHAR},",
          "summary = #{summary,jdbcType=VARCHAR},",
          "publish_date = #{publishDate,jdbcType=TIMESTAMP},",
          "column_id = #{columnId,jdbcType=INTEGER},",
          "views = #{views,jdbcType=INTEGER},",
          "tags = #{tags,jdbcType=VARCHAR},",
          "comments = #{comments,jdbcType=VARCHAR},",
          "blog_img = #{blogImg,jdbcType=VARCHAR},",
          "blog_state = #{blogState,jdbcType=TINYINT},",
          "admire_state = #{admireState,jdbcType=TINYINT},",
          "comments_state = #{commentsState,jdbcType=TINYINT},",
          "recommend_state = #{recommendState,jdbcType=TINYINT},",
          "reprint_state = #{reprintState,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARBINARY}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Blog record);

    @Update({
        "update blog_content",
        "set title = #{title,jdbcType=VARCHAR},",
          "summary = #{summary,jdbcType=VARCHAR},",
          "publish_date = #{publishDate,jdbcType=TIMESTAMP},",
          "column_id = #{columnId,jdbcType=INTEGER},",
          "views = #{views,jdbcType=INTEGER},",
          "tags = #{tags,jdbcType=VARCHAR},",
          "comments = #{comments,jdbcType=VARCHAR},",
          "blog_img = #{blogImg,jdbcType=VARCHAR},",
          "blog_state = #{blogState,jdbcType=TINYINT},",
          "admire_state = #{admireState,jdbcType=TINYINT},",
          "comments_state = #{commentsState,jdbcType=TINYINT},",
          "recommend_state = #{recommendState,jdbcType=TINYINT},",
          "reprint_state = #{reprintState,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Blog record);
}