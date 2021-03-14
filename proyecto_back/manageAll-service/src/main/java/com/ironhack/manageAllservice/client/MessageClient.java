package com.ironhack.manageAllservice.client;

import com.ironhack.manageAllservice.controller.dtos.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient("message-service")
public interface MessageClient {

    @GetMapping("/messages")
    @ResponseStatus(HttpStatus.OK)
    public List<MessageDTO> allMessages();

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMessage(@RequestBody MessageDTO messageDTO);

    @PutMapping("/message/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void markAsRead(@PathVariable ("id") Integer id);

    @DeleteMapping("/message/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMessage(@PathVariable ("id") Integer id);
}
