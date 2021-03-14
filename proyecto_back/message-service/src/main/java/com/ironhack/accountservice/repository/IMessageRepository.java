package com.ironhack.accountservice.repository;

import com.ironhack.accountservice.model.*;
import org.springframework.data.jpa.repository.*;

public interface IMessageRepository extends JpaRepository<Message, Integer> {
}
