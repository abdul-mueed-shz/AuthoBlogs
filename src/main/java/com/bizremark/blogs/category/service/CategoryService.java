package com.bizremark.blogs.category.service;

import com.bizremark.blogs.category.dto.CategoryFilterDto;
import com.bizremark.blogs.category.info.CategoryResponse;
import com.bizremark.blogs.category.model.dao.CategoryDao;
import com.bizremark.blogs.common.dto.PageRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryDao categoryDao;

    public Page<CategoryResponse> getAllCategories(CategoryFilterDto categoryFilterDto, PageRequestDto pageRequestDto) {
        return categoryDao.getAllCategories(categoryFilterDto, pageRequestDto);
    }
}
