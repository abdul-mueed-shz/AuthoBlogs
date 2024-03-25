package com.bizremark.blogs.blog.mapper;

import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;
import com.bizremark.blogs.blog.model.entity.Blog;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlogInfoMapper {
    Blog blogInfoToBlog(BlogInfo blogInfo);

    BlogInfo blogToBlogInfo(Blog blog);


    List<BlogResponse> blogListToBlogResponseList(List<Blog> blogList);

    BlogResponse blogToBlogResponse(Blog blog);
}
