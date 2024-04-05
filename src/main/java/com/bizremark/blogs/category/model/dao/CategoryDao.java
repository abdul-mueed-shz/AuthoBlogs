package com.bizremark.blogs.category.model.dao;

import com.bizremark.blogs.category.info.CategoryInfo;
import com.bizremark.blogs.category.info.CategoryResponse;
import com.bizremark.blogs.category.mapper.CategoryInfoMapper;
import com.bizremark.blogs.category.model.entity.Category;
import com.bizremark.blogs.category.model.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryDao {
    private final CategoryRepository categoryRepository;
    private final CategoryInfoMapper categoryInfoMapper;

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryInfoMapper.categoryListToCategoryResponseList(categories);
    }

    public Boolean doesCategoryExist(Long id) {
        return categoryRepository.existsById(id);
    }
}
