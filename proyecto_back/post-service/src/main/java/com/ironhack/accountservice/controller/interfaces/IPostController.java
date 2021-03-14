package com.ironhack.accountservice.controller.interfaces;

import com.ironhack.accountservice.controller.dtos.*;
import com.ironhack.accountservice.model.*;

import java.util.*;

public interface IPostController {


    List<Post> getAllPost();

    Post getPost(Integer id);

    Post addPost(PostDTO postDTO);

}
