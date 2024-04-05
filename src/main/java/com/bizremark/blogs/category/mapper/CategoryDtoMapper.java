package com.bizremark.blogs.category.mapper;

import com.bizremark.blogs.category.dto.CategoryDto;
import com.bizremark.blogs.category.info.CategoryInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {
    CategoryInfo categoryDtoToInfo(CategoryDto categoryDto);

    CategoryDto categoryInfoToDto(CategoryInfo categoryInfo);
}
