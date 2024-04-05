package com.bizremark.blogs.blog.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HandleThumbnailUploadService implements HandleFileUpload {

    private static final Set<String> ALLOWED_MIME_TYPES = Set.of(
            "image/jpeg",
            "image/png",
            "image/gif",
            "image/svg+xml"
    );
    @Value("${app.upload.base-folder}")
    private String baseUploadFolder;

    @Value("${app.upload.thumbnail-location}")
    private String uploadLocation;


    private final HttpServletRequest request;

    public String uploadFile(MultipartFile file, String fileName, Long id) {
        String contentType = file.getContentType();
        if (contentType == null || !ALLOWED_MIME_TYPES.contains(contentType)) {
            throw new ApplicationContextException("Unsupported file type: " + contentType);
        }
        try {
            Path basePath = Paths.get(baseUploadFolder);
            Path mediaPath = basePath.resolve(uploadLocation).resolve(id.toString());

            if (!Files.exists(mediaPath)) {
                Files.createDirectories(mediaPath);
            }

            Path filePath = mediaPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            return filePath.toAbsolutePath().toString();
        } catch (IOException e) {
            throw new ApplicationContextException(e.getMessage());
        }
    }

    public String getFileUrl(Long id, String fileName) {
        return String.format("%s://%s:%d/%s", request.getScheme(), request.getServerName(),
                request.getServerPort(),
                Paths.get(uploadLocation)
                        .resolve(id.toString())
                        .resolve(fileName)
                        .toString()
                        .replace("\\", "/"));
    }
}
