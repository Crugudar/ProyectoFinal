package com.ironhack.manageAllservice.client;

import com.ironhack.manageAllservice.controller.dtos.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

@FeignClient("post-service")
public interface PostClient {

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> getAllPost();

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO getPost( @PathVariable("id") Integer id);

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO addPost(@RequestBody  PostDTO postDTO);

    @DeleteMapping("/post/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") Integer id);

    @PostMapping("/image/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadImage( @RequestParam("imageFile") MultipartFile file);

    @GetMapping("/image/get/{imageName}")
    @ResponseStatus(HttpStatus.OK)
    public ImageDTO getImage(@PathVariable("imageName") String imageName);

    @DeleteMapping("/image/delete/{imageName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable("imageName") String imageName);
}
