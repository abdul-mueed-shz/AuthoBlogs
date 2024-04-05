package com.bizremark.blogs.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class BlogAttachmentService {
    @Value("${app.upload.base-folder}")
    private String uploadLocation;

    public void uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return;
        }

        try {
            Path resourcesPath = Paths.get("src/main/resources");
            Path mediaPath = resourcesPath.resolve(uploadLocation);

            if (!Files.exists(mediaPath)) {
                Files.createDirectories(mediaPath);
            }

            Path filePath = mediaPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);

            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public byte[] getFile(String filename) throws IOException {
        Path path = Paths.get(uploadLocation + "/" + filename);
        return Files.readAllBytes(path);
    }
}
