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
public class MessageController implements IMessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IMessageRepository messageRepository;

    @GetMapping("/messages")
    @ResponseStatus(HttpStatus.OK)
    public List<Message> allMessages(){
        System.out.println("heyyy");
       return  messageService.allMessages();
    }
    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMessage(@RequestBody MessageDTO messageDTO){
        System.out.println(messageDTO);
        messageService.saveMessage(messageDTO);
    }

    @PutMapping("/message/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void markAsRead(@PathVariable ("id") Integer id){
        messageService.markAsRead(id);
    }

    @DeleteMapping("/message/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable ("id") Integer id){
        messageService.delete(id);
    }
}
