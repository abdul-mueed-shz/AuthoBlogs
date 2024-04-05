package com.bizremark.blogs.category.service;

import com.bizremark.blogs.category.info.CategoryInfo;
import com.bizremark.blogs.category.info.CategoryResponse;
import com.bizremark.blogs.category.model.dao.CategoryDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryDao categoryDao;

    public List<CategoryResponse> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
