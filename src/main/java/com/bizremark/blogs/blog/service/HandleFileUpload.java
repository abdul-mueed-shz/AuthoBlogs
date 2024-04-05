package com.bizremark.blogs.blog.service;

import org.springframework.web.multipart.MultipartFile;

public interface HandleFileUpload {
    String uploadFile(MultipartFile file, String fileName, Long id);

    String getFileUrl(Long id, String fileName);

}
