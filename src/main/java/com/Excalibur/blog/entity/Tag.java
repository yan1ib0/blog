package com.Excalibur.blog.entity;

import java.util.Date;

public class Tag {
    private Integer id;

    private String name;

    private String blogCount;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(String blogCount) {
        this.blogCount = blogCount == null ? null : blogCount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogCount='" + blogCount + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}