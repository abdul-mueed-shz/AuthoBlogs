package com.bizremark.blogs.blog.controller;

import com.bizremark.blogs.blog.service.BlogAttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(path = "api/v1/blog-attachment")
@RequiredArgsConstructor
public class BlogAttachmentController {
    private final BlogAttachmentService blogAttachmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        blogAttachmentService.uploadFile(file);
    }
}
