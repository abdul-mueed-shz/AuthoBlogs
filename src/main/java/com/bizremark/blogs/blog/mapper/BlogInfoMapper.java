package com.bizremark.blogs.blog.mapper;

import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;
import com.bizremark.blogs.blog.model.entity.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlogInfoMapper {
    Blog blogInfoToBlog(BlogInfo blogInfo);

    BlogInfo blogToBlogInfo(Blog blog);


    List<BlogResponse> blogListToBlogResponseList(List<Blog> blogList);

    BlogResponse blogToBlogResponse(Blog blog);

    Blog blogResponseToBlog(BlogResponse blog);

    Blog updateBlogFromBlogInfo(BlogInfo source, @MappingTarget Blog target);
}
