package com.Excalibur.blog.entity;

import java.util.Date;

public class Comment {
    private Integer id;

    private String replyName;

    private String replyEmail;

    private Integer blogId;

    private Date publishDate;

    private Byte authorState;

    private Byte replyState;

    private String replyContent;

    private Integer parentId;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName == null ? null : replyName.trim();
    }

    public String getReplyEmail() {
        return replyEmail;
    }

    public void setReplyEmail(String replyEmail) {
        this.replyEmail = replyEmail == null ? null : replyEmail.trim();
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Byte getAuthorState() {
        return authorState;
    }

    public void setAuthorState(Byte authorState) {
        this.authorState = authorState;
    }

    public Byte getReplyState() {
        return replyState;
    }

    public void setReplyState(Byte replyState) {
        this.replyState = replyState;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}