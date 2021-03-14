package com.ironhack.accountservice.repository;

import com.ironhack.accountservice.model.*;
import org.springframework.data.jpa.repository.*;

public interface IPostRepository  extends JpaRepository<Post, Integer> {
}
