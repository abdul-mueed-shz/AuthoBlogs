package com.bizremark.blogs.category.model.repository;

import com.bizremark.blogs.category.dto.CategoryFilterDto;
import com.bizremark.blogs.category.info.CategoryResponse;
import com.bizremark.blogs.common.dto.PageRequestDto;
import org.springframework.data.domain.Page;

public interface CategoryRepository {
    Page<CategoryResponse> getAllCategories(CategoryFilterDto categoryFilterDto, PageRequestDto pageRequestDto);

    Boolean doesCategoryExist(Long id);
}
