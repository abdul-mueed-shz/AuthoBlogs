package com.bizremark.blogs.blog.info;

import com.bizremark.blogs.category.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class BlogInfo {
    private String title;
    private String description;
    private Category category;

}
