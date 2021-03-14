package com.ironhack.manageAllservice.controller.impl;

import com.ironhack.manageAllservice.controller.dtos.*;

import com.ironhack.manageAllservice.controller.interfaces.IManageAllController;
import com.ironhack.manageAllservice.service.interfaces.IManageAllService;
import com.ironhack.manageAllservice.utils.payload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class ManageAllController implements IManageAllController {

    @Autowired
    private IManageAllService manageAllService;


    @GetMapping("/messages")
    @ResponseStatus(HttpStatus.OK)
    public List<MessageDTO> allMessages(){
        return  manageAllService.allMessages();
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMessage(@RequestBody MessageDTO messageDTO) {
        System.out.println(messageDTO.getClientName());
        manageAllService.addMessage(messageDTO);
    }

    @PutMapping("/message/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void markAsRead(@PathVariable("id") Integer id) {
        manageAllService.markAsRead(id);
    }

    @DeleteMapping("/message/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMessage(@PathVariable("id") Integer id) {
        manageAllService.deleteMessage(id);
    }

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> getAllPost() {
        return manageAllService.findAll();
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO getPost(@PathVariable("id") Integer id) {
        return manageAllService.getPost(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO addPost(@RequestBody PostDTO postDTO) {
        return manageAllService.addPost(postDTO);
    }

    @DeleteMapping("/post/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") Integer id) {
        manageAllService.deletePost(id);
    }

    @PostMapping("/image/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) {
        manageAllService.uploadImage(file);
    }

    @GetMapping("/image/get/{imageName}")
    @ResponseStatus(HttpStatus.OK)
    public ImageDTO getImage(@PathVariable("imageName") String imageName) {
        return manageAllService.getImage(imageName);
    }

    @DeleteMapping("/image/delete/{imageName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable("imageName") String imageName) {
        manageAllService.deleteImage(imageName);
    }

    @PostMapping("/user/auth/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        return manageAllService.authenticateUser(loginRequest);
    }
}