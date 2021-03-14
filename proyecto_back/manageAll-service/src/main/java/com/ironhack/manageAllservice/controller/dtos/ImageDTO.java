package com.ironhack.manageAllservice.controller.dtos;

public class ImageDTO {


    private Integer imageId;
    private String imageName;
    private String imageType;
    private PostDTO post;
    private byte[] picByte;

    public ImageDTO() {
    }

    public ImageDTO(String imageName, String imageType, PostDTO post, byte[] picByte) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.post = post;
        this.picByte = picByte;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
