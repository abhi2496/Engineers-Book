package com.gtu.EngBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
public class ArticlesModel implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long user_id;

    @Column(name = "article_id")
    private long article_id;

    @Column(name = "article_type")
    private int article_type;

    @Column(name = "article_text")
    private String article_text;

    @Column(name = "article_image")
    private Blob article_image;

    @Column(name = "create_time")
    private long create_time;


    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getArticle_text() {
        return article_text;
    }

    public void setArticle_text(String article_text) {
        this.article_text = article_text;
    }

    public Blob getArticle_image() {
        return article_image;
    }

    public void setArticle_image(Blob article_image) {
        this.article_image = article_image;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }
}
