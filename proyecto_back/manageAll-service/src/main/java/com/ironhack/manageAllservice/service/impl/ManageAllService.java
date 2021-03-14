package com.ironhack.manageAllservice.service.impl;
import com.ironhack.manageAllservice.client.*;
import com.ironhack.manageAllservice.controller.dtos.*;
import com.ironhack.manageAllservice.security.jwt.*;
import com.ironhack.manageAllservice.security.services.*;
import com.ironhack.manageAllservice.service.interfaces.IManageAllService;
import com.ironhack.manageAllservice.utils.payload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.*;

import java.util.*;


@Service
public class ManageAllService implements IManageAllService {

    @Autowired
    private MessageClient messageClient;

    @Autowired
    private PostClient postClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public void addMessage(MessageDTO messageDTO) {
        System.out.println(messageDTO);
        messageClient.addMessage(messageDTO);
    }

    public void markAsRead(Integer id) {
        messageClient.markAsRead(id);
    }

    public void deleteMessage(Integer id) {
        messageClient.deleteMessage(id);
    }

    public PostDTO getPost(Integer id) {
        return postClient.getPost(id);
    }

    public PostDTO addPost(PostDTO postDTO) {
        return postClient.addPost(postDTO);
    }

    public void deletePost(Integer id) {
        postClient.deletePost(id);
    }

    public void uploadImage(MultipartFile file) {
        postClient.uploadImage(file);
    }

    public ImageDTO getImage(String imageName) {
        return postClient.getImage(imageName);
    }

    public void deleteImage(String imageName) {
        postClient.deleteImage(imageName);
    }

    public List<PostDTO> findAll() {
        return postClient.getAllPost();
    }

    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(loginRequest.getUsername());
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(loginRequest.getUsername());
        String jwt = jwtUtils.generateJwtToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    public List<MessageDTO> allMessages() {
        return messageClient.allMessages();
    }


}
