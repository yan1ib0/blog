package com.Excalibur.blog.dao;

import com.Excalibur.blog.entity.Comment;
import com.Excalibur.blog.entity.CommentExample;
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
public interface CommentMapper {
    @SelectProvider(type=CommentSqlProvider.class, method="countByExample")
    long countByExample(CommentExample example);

    @Delete({
        "delete from comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into comment (id, reply_name, ",
        "reply_email, blog_id, ",
        "publish_date, author_state, ",
        "reply_state, reply_content, ",
        "parent_id, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{replyName,jdbcType=VARCHAR}, ",
        "#{replyEmail,jdbcType=VARCHAR}, #{blogId,jdbcType=INTEGER}, ",
        "#{publishDate,jdbcType=TIMESTAMP}, #{authorState,jdbcType=TINYINT}, ",
        "#{replyState,jdbcType=TINYINT}, #{replyContent,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER}, #{createTime,jdbcType=VARCHAR})"
    })
    int insert(Comment record);

    @InsertProvider(type=CommentSqlProvider.class, method="insertSelective")
    int insertSelective(Comment record);

    @SelectProvider(type=CommentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reply_name", property="replyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="reply_email", property="replyEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_id", property="blogId", jdbcType=JdbcType.INTEGER),
        @Result(column="publish_date", property="publishDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="author_state", property="authorState", jdbcType=JdbcType.TINYINT),
        @Result(column="reply_state", property="replyState", jdbcType=JdbcType.TINYINT),
        @Result(column="reply_content", property="replyContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    List<Comment> selectByExample(CommentExample example);

    @Select({
        "select",
        "id, reply_name, reply_email, blog_id, publish_date, author_state, reply_state, ",
        "reply_content, parent_id, create_time",
        "from comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reply_name", property="replyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="reply_email", property="replyEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_id", property="blogId", jdbcType=JdbcType.INTEGER),
        @Result(column="publish_date", property="publishDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="author_state", property="authorState", jdbcType=JdbcType.TINYINT),
        @Result(column="reply_state", property="replyState", jdbcType=JdbcType.TINYINT),
        @Result(column="reply_content", property="replyContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    Comment selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Comment record);

    @Update({
        "update comment",
        "set reply_name = #{replyName,jdbcType=VARCHAR},",
          "reply_email = #{replyEmail,jdbcType=VARCHAR},",
          "blog_id = #{blogId,jdbcType=INTEGER},",
          "publish_date = #{publishDate,jdbcType=TIMESTAMP},",
          "author_state = #{authorState,jdbcType=TINYINT},",
          "reply_state = #{replyState,jdbcType=TINYINT},",
          "reply_content = #{replyContent,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Comment record);
}