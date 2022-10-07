package com.leo.webCore.peristence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "listenguideline")
public class ListenGuideLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ListenGuideLineId;

    @Column(name = "image")
    private String image;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "createddate")
    private String createdDate;

    @Column(name = "modifiedate")
    private String modifieDate;

   @OneToMany(mappedBy = "listenGuideLine", fetch = FetchType.LAZY)
    private List<Comment> listComment;

    public int getListenGuideLineId() {
        return ListenGuideLineId;
    }

    public void setListenGuideLineId(int listenGuideLineId) {
        ListenGuideLineId = listenGuideLineId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifieDate() {
        return modifieDate;
    }

    public void setModifieDate(String modifieDate) {
        this.modifieDate = modifieDate;
    }

    public List<Comment> getListComment() {
        return listComment;
    }

    public void setListComment(List<Comment> listComment) {
        this.listComment = listComment;
    }
}
