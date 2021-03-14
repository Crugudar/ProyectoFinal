package com.ironhack.userservice.service.impl;

import com.ironhack.userservice.controller.dtos.*;
import com.ironhack.userservice.model.*;
import com.ironhack.userservice.repository.*;
import com.ironhack.userservice.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;


import java.util.*;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO buildUserDTO(User user){

        return new UserDTO(user.getUsername(), user.getEmail(), user.getPassword(), user.getRoles());
    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        User user = checkUserName(userName);
        return buildUserDTO(user);
    }

    private User checkUserName(String username) {
        Optional<User> output = userRepository.findByUsername(username);
        System.out.println(username+"......."+"........"+output.get().getUsername());
        if (output.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not an user with such an username");
        }

        return output.get();
    }
}
