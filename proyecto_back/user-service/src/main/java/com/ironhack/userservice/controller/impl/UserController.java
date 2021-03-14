package com.ironhack.userservice.controller.impl;

import com.ironhack.userservice.controller.dtos.*;
import com.ironhack.userservice.controller.interfaces.*;
import com.ironhack.userservice.service.interfaces.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController implements IUserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user/search/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserByUserName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }


}
