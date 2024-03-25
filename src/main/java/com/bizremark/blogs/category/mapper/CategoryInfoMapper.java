package com.bizremark.blogs.category.mapper;

import com.bizremark.blogs.category.info.CategoryInfo;
import com.bizremark.blogs.category.info.CategoryResponse;
import com.bizremark.blogs.category.model.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryInfoMapper {
    Category categoryInfoToCategory(CategoryInfo categoryInfo);

    CategoryInfo categoryToCategoryInfo(Category category);

    List<CategoryInfo> categoryListToCategoryInfoList(List<Category> categoryList);

    List<Category> categoryInfoListToCategoryList(List<CategoryInfo> categoryInfoList);

    List<CategoryResponse> categoryListToCategoryResponseList(List<Category> categoryList);

    CategoryResponse categoryToCategoryResponse(Category category);

}
