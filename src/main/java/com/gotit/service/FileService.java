package com.gotit.service;

import com.gotit.entity.UserAccount;
import com.gotit.entity.UserRepository;
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
    @Value("${com.got-it.path-to-folder-with-avatar}")
    private String folderWithAvatar;

    private final UserRepository userRepository;

    public FileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveImage(MultipartFile imageFile) throws Exception {
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folderWithPhotos + imageFile.getOriginalFilename());
        Files.write(path, bytes);

    }

    public void saveAvatar(MultipartFile imageFile, String userEmail) throws Exception {
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folderWithAvatar + imageFile.getOriginalFilename());
        Files.write(path, bytes);
        setUseAvatar(userEmail, imageFile.getOriginalFilename());
    }

    public byte[] getImage(String imageName) throws Exception {
        Path path = Paths.get(folderWithPhotos + imageName);
        System.out.println(path);
        return Files.readAllBytes(path);
    }

    private void setUseAvatar(String userEmail, String avatarName) {
        UserAccount userAccount = userRepository.findByEmail(userEmail).orElseThrow();
        userAccount.setAvatar(avatarName);
        userRepository.save(userAccount);
    }


}
