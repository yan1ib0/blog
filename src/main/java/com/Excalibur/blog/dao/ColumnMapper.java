package com.Excalibur.blog.dao;

import com.Excalibur.blog.entity.Column;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ColumnMapper {
    @Delete({
        "delete from column",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into column (id, name, ",
        "intro, blog_count, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{blogCount,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Column record);

    @InsertProvider(type=ColumnSqlProvider.class, method="insertSelective")
    int insertSelective(Column record);

    @Select({
        "select",
        "id, name, intro, blog_count, create_time",
        "from column",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_count", property="blogCount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Column selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ColumnSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Column record);

    @Update({
        "update column",
        "set name = #{name,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "blog_count = #{blogCount,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Column record);
}