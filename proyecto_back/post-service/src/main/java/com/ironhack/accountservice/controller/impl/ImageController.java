package com.ironhack.accountservice.controller.impl;


import com.ironhack.accountservice.controller.interfaces.*;
import com.ironhack.accountservice.model.*;
import com.ironhack.accountservice.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;
import java.util.zip.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController implements IImageController {

    @Autowired
    private IImageRepository imageRepository;

    @PostMapping("/image/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadImage( @RequestParam("imageFile") MultipartFile file) throws IOException {

        System.out.println("Original Image Byte Size - " + file.getBytes().length);

        Image img = new Image(file.getOriginalFilename(), file.getContentType(),
                compressBytes(file.getBytes()));
        imageRepository.save(img);
    }

    @GetMapping("/image/get/{imageName}")
    @ResponseStatus(HttpStatus.OK)
    public Image getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<Image> retrievedImage = imageRepository.findByImageName(imageName);
        Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }

    @DeleteMapping("/image/delete/{imageName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable("imageName") String imageName) {
        Optional<Image> image = imageRepository.findByImageName(imageName);
        imageRepository.deleteById(image.get().getId());
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
