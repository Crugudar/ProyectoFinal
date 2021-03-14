package com.ironhack.manageAllservice.controller.dtos;

import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.*;
import java.util.*;

public class PostDTO {

    private Integer postId;
    @NotEmpty
    private String postTitle;
    private Date createdAt;
    @NotEmpty
    private String body;

    private ImageDTO imageId;

    public PostDTO() {
    }

    public PostDTO(String postTitle, Date createdAt, String body, ImageDTO imageId) {
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

    public ImageDTO getImageId() {
        return imageId;
    }

    public void setImageId(ImageDTO imageId) {
        this.imageId = imageId;
    }
}
