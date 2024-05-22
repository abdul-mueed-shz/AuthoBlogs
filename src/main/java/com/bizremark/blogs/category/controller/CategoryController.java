package com.bizremark.blogs.category.controller;

import com.bizremark.blogs.category.dto.CategoryFilterDto;
import com.bizremark.blogs.category.info.CategoryResponse;
import com.bizremark.blogs.category.service.CategoryService;
import com.bizremark.blogs.common.dto.PageRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> getAllCategories(CategoryFilterDto categoryFilterDto,
                                                                   PageRequestDto pageRequestDto) {
        return ResponseEntity.ok(categoryService.getAllCategories(categoryFilterDto, pageRequestDto));
    }
}
