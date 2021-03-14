package com.ironhack.manageAllservice.service.interfaces;

import com.ironhack.manageAllservice.controller.dtos.*;
import com.ironhack.manageAllservice.utils.payload.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.util.List;

public interface IManageAllService {


    void addMessage(MessageDTO messageDTO);

    void markAsRead( Integer id);

    void deleteMessage(Integer id);

    PostDTO getPost(  Integer id);

    PostDTO addPost( PostDTO postDTO);

    void deletePost( Integer id);

    void uploadImage( MultipartFile file);

    ImageDTO getImage(String imageName);

    void deleteImage( String imageName);

    List<PostDTO> findAll();

    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);

    List<MessageDTO> allMessages();
}
