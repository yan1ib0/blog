package com.Excalibur.blog.dao;

import com.Excalibur.blog.entity.Tag;
import com.Excalibur.blog.entity.TagExample;
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
public interface TagMapper {
    @SelectProvider(type=TagSqlProvider.class, method="countByExample")
    long countByExample(TagExample example);

    @Delete({
        "delete from tag",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tag (id, name, ",
        "blog_count, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{blogCount,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Tag record);

    @InsertProvider(type=TagSqlProvider.class, method="insertSelective")
    int insertSelective(Tag record);

    @SelectProvider(type=TagSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_count", property="blogCount", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Tag> selectByExample(TagExample example);

    @Select({
        "select",
        "id, name, blog_count, create_time",
        "from tag",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="blog_count", property="blogCount", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Tag selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TagSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    @UpdateProvider(type=TagSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    @UpdateProvider(type=TagSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Tag record);

    @Update({
        "update tag",
        "set name = #{name,jdbcType=VARCHAR},",
          "blog_count = #{blogCount,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Tag record);
}