package com.ironhack.accountservice.service.impl;

import com.ironhack.accountservice.controller.dtos.*;
import com.ironhack.accountservice.model.*;
import com.ironhack.accountservice.repository.*;
import com.ironhack.accountservice.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;

import java.util.*;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private IMessageRepository messageRepository;


    public void saveMessage(MessageDTO messageDTO) {
        Message message=new Message();
        message.setClientName(messageDTO.getClientName());
        message.setClientEmail(messageDTO.getClientEmail());
        message.setMessageBody(messageDTO.getMessageBody());
        message.setPhone(messageDTO.getPhone());
        message.setRead(messageDTO.getRead());
        message.setCreatedAt(messageDTO.getCreateAt());

        messageRepository.save(message);
    }


    public void markAsRead(Integer id) {
        Optional<Message> message=messageRepository.findById(id);
        if(!message.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found");
        }
        message.get().setRead(true);
        messageRepository.save(message.get());
    }


    public void delete(Integer id) {
        Optional<Message> message=messageRepository.findById(id);
        if(!message.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found");
        }
        messageRepository.delete(message.get());
    }


    public List<Message> allMessages() {
        return messageRepository.findAll();
    }
}
