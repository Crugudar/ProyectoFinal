package com.ironhack.accountservice.model;

import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @NotEmpty
    private String postTitle;
    private Date createdAt;
    @NotEmpty
    @Type(type = "text")
    private String body;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Image imageId;

    public Post() {
    }

    public Post(String postTitle, Date createdAt, String body, Image imageId) {
        this.postTitle = postTitle;
        this.createdAt = createdAt;
        this.body = body;
        this.imageId = imageId;
    }

    public Integer getId() {
        return postId;
    }

    public void setId(Integer id) {
        this.postId = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Image getImageId() {
        return imageId;
    }

    public void setImageId(Image imageId) {
        this.imageId = imageId;
    }
}
