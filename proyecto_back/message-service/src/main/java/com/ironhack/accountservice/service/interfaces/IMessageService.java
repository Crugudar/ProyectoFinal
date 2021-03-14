package com.ironhack.accountservice.service.interfaces;

import com.ironhack.accountservice.controller.dtos.*;
import com.ironhack.accountservice.model.*;

import java.util.*;

public interface IMessageService {
    void saveMessage(MessageDTO messageDTO);

    void markAsRead(Integer id);

    void delete(Integer id);

    List<Message> allMessages();
}
