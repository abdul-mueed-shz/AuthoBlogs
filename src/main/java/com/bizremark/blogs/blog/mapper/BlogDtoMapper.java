package com.bizremark.blogs.blog.mapper;

import com.bizremark.blogs.blog.dto.BlogDto;
import com.bizremark.blogs.blog.info.BlogInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface BlogDtoMapper {
    BlogInfo blogDtoToBlogInfo(BlogDto blogDto);

    BlogDto blogInfoToBlogDto(BlogInfo blogInfo);
}
