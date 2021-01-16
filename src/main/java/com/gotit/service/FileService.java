package com.gotit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    @Value("${com.got-it.path-to-folder-with-photos}")
    private String folderWithPhotos;

    public void saveImage(MultipartFile imageFile) throws Exception {
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folderWithPhotos + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    public byte[] getImage(String imageName) throws Exception {
        Path path = Paths.get(folderWithPhotos + imageName);
        System.out.println(path);
        return Files.readAllBytes(path);
    }


}
