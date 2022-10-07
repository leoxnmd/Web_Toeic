package com.leo.webCore.peristence.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "comment")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;

    @Column(name = "content")
    private String content;

    @Column(name = "userId")
    private int userId;

    @Column(name = "listenguidelineid")
    private int ListenGuideLineId;

    @Column(name = "createddate")
    private String createdDate;

    //quan hệ comment 1...n listenguideline
    @ManyToOne
    @JoinColumn(name = "listenguidelineid")
    private ListenGuideLine listenGuideLine;

    //quan hệ user 1..n comment
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getListenGuideLineId() {
        return ListenGuideLineId;
    }

    public void setListenGuideLineId(int listenGuideLineId) {
        ListenGuideLineId = listenGuideLineId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
