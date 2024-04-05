package com.bizremark.blogs.blog.dto;

import com.bizremark.blogs.category.model.entity.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BlogDto {
    @NotNull(message = "Title must not be null")
    @Size(max = 255)
    private String title;

    @NotNull(message = "Category must not be null")
    private Category category;

    @Size(max = 2000, message = "Description must be of less than 2000 characters")
    private String description;

    @NotNull(message = "thumbnail is required")
    private MultipartFile thumbnail;
}
