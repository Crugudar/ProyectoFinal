package com.ironhack.manageAllservice.client;

import com.ironhack.manageAllservice.controller.dtos.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/user/search/{userName}")
    @ResponseStatus(HttpStatus.OK)
    UserDTO getUserByUserName(@PathVariable String userName);

}
