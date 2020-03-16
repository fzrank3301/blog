package com.wang.blog.entity;


public class ArticleEntity {
    private Integer id;
    private String author;
    private String title;
    private String context;
    private Integer likecount;
    private String createtime;
    private String time;
    private int authorid;
    private AuthorEntity authorEntity;
    private String fullcontext;

    public String getFullcontext() {
        return fullcontext;
    }

    public void setFullcontext(String fullcontext) {
        this.fullcontext = fullcontext;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
