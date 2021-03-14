package com.ironhack.accountservice.controller.dtos;

import com.ironhack.accountservice.model.*;

public class PostDTO {
    private String postTitle;
    private String body;
    private Image imageId;


    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
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
