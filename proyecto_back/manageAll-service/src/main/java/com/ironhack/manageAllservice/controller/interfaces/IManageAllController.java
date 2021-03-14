package com.ironhack.manageAllservice.controller.interfaces;

import com.ironhack.manageAllservice.controller.dtos.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;


import java.util.List;

public interface IManageAllController {

    public void addMessage( MessageDTO messageDTO);

    void markAsRead( Integer id);

    void deleteMessage( Integer id);

    List<PostDTO> getAllPost();

    PostDTO getPost( Integer id);

    PostDTO addPost(PostDTO postDTO);

    void deletePost(Integer id);

    void uploadImage(MultipartFile file);

    ImageDTO getImage( String imageName);

    void deleteImage( String imageName);

}
