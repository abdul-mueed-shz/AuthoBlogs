package com.bizremark.blogs.blog.info;

import com.bizremark.blogs.category.model.entity.Category;
import com.bizremark.blogs.user.info.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    private Category category;
    private String thumbnailPath;
    private UserResponse user;
}
