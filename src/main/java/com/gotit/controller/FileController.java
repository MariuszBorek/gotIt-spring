package com.gotit.controller;

import com.gotit.dto.ImageModel;
import com.gotit.service.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


@CrossOrigin("*")
@RestController
@RequestMapping("/image")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload-photo")
    public void uploadImage(@RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        try {
            fileService.saveImage(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PostMapping("/upload-avatar/{email}")
    public void uploadAvatar(@RequestParam("imageFile") MultipartFile imageFile,
                             @PathVariable("email") String email) throws IOException {
        try {
            fileService.saveAvatar(imageFile, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = { "/get/{imageName}" })
    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
        Path path = Paths.get("/Users/MariuszBorek/Documents/repository/gotit-frontend/src/assets/images/photos/" + imageName);
        return new ImageModel(imageName, "jpeg", Files.readAllBytes(path));
    }


}
