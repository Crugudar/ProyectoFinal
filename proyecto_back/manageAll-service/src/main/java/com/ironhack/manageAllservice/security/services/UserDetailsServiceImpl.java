package com.ironhack.manageAllservice.security.services;


import com.ironhack.manageAllservice.client.*;
import com.ironhack.manageAllservice.controller.dtos.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        UserDTO userDTO = userClient.getUserByUserName(userName);
        userDTO.setRoles("ADMIN");
        return new UserDetailsImpl(userDTO);
    }
}
