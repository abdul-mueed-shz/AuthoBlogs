package com.bizremark.blogs.category.model.dao;

import com.bizremark.blogs.category.config.CategorySpecifications;
import com.bizremark.blogs.category.dto.CategoryFilterDto;
import com.bizremark.blogs.category.info.CategoryResponse;
import com.bizremark.blogs.category.mapper.CategoryInfoMapper;
import com.bizremark.blogs.category.model.entity.Category;
import com.bizremark.blogs.category.model.repository.CategoryJpaRepository;
import com.bizremark.blogs.category.model.repository.CategoryRepository;
import com.bizremark.blogs.common.dto.PageRequestDto;
import com.bizremark.blogs.common.service.PaginationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryDao implements CategoryRepository {
    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryInfoMapper categoryInfoMapper;
    private final PaginationHelper paginationHelper;

    public Page<CategoryResponse> getAllCategories(CategoryFilterDto categoryFilterDto, PageRequestDto pageRequestDto) {
        Pageable pageable = paginationHelper.map(pageRequestDto);

        Specification<Category> specs = Specification.where(CategorySpecifications.hasName(categoryFilterDto.getName()));

        Page<Category> categoryPage = categoryJpaRepository.findAll(specs, pageable);
        return paginationHelper.mapPageEntitiesToInfos(categoryPage, categoryInfoMapper::categoryToCategoryResponse);
    }

    public Boolean doesCategoryExist(Long id) {
        return categoryJpaRepository.existsById(id);
    }
}
