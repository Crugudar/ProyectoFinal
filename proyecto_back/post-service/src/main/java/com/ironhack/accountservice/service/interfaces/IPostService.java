package com.ironhack.accountservice.service.interfaces;

import com.ironhack.accountservice.controller.dtos.*;
import com.ironhack.accountservice.model.*;

public interface IPostService {
    Post addPost(PostDTO postDTO);

    void deletePost(Integer id);
}
