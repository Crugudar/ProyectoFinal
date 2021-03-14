package com.ironhack.accountservice.repository;

import com.ironhack.accountservice.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface IImageRepository extends JpaRepository<Image, Integer>{

    Optional<Image> findByImageName(String name);

    Optional<Image> findByImageId(Integer id);
}
