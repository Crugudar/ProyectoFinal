package com.ironhack.accountservice.controller.impl;


import com.ironhack.accountservice.controller.dtos.*;
import com.ironhack.accountservice.controller.interfaces.*;
import com.ironhack.accountservice.model.*;
import com.ironhack.accountservice.repository.*;
import com.ironhack.accountservice.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostController implements IPostController {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IPostService postService;


    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPost( @PathVariable("id") Integer id) {
        return postRepository.findById(id).get();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody PostDTO postDTO) {
        return postService.addPost(postDTO);
    }

    @DeleteMapping("/post/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") Integer id) {
        postService.deletePost(id);
    }
}
