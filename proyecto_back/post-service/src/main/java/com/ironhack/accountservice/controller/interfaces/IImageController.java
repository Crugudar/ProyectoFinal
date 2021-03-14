package com.ironhack.accountservice.controller.interfaces;

import com.ironhack.accountservice.model.*;
import org.springframework.web.multipart.*;

import java.io.*;

public interface IImageController {

    void uploadImage(MultipartFile file) throws IOException;

    Image getImage(String imageName) throws IOException;
}
