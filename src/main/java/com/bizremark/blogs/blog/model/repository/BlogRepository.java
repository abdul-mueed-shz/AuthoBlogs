package com.bizremark.blogs.blog.model.repository;

import com.bizremark.blogs.blog.dto.BlogFilterDto;
import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;
import com.bizremark.blogs.common.dto.PageRequestDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogRepository {
    Boolean blogExists(Long id);

    Page<BlogResponse> getAllBlogs(BlogFilterDto filterDto, PageRequestDto pageRequestDto);

    Page<BlogResponse> getUserBlogs(String username, PageRequestDto pageRequestDto);

    BlogResponse getBlog(Long id);

    Long createBlog(BlogInfo blogInfo);

    void updateBlog(BlogInfo blogInfo, Long blogId);

    String getAbsoluteFilePath(Long blogId);


    String getThumbnail(Long blogId);

    void deleteBlog(Long blogId);
}
