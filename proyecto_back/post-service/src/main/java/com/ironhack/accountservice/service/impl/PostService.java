package com.ironhack.accountservice.service.impl;

import com.ironhack.accountservice.controller.dtos.*;
import com.ironhack.accountservice.model.*;
import com.ironhack.accountservice.repository.*;
import com.ironhack.accountservice.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IImageRepository imageRepository;


    public Post addPost(PostDTO postDTO) {

        Post post = new Post();
        post.setPostTitle(postDTO.getPostTitle());
        post.setBody(postDTO.getBody());
        Image image = imageRepository.findByImageId(postDTO.getImageId().getId()).get();
        post.setImageId(image);
        postRepository.save(post);
        return post;
    }

    public void deletePost(Integer id) {
        if(postRepository.existsById(id)) {
            Post post = postRepository.findById(id).get();
            Image image = imageRepository.findByImageId(post.getImageId().getId()).get();
            postRepository.deleteById(post.getId());
            imageRepository.deleteById(image.getId());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
    }
}
