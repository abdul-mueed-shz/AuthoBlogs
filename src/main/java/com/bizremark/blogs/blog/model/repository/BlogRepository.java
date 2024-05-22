package com.bizremark.blogs.blog.model.repository;

import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;

import java.util.List;

public interface BlogRepository {
    Boolean blogExists(Long id);

    List<BlogResponse> getAllBlogs();

    List<BlogResponse> getUserBlogs(String username);
    
    BlogResponse getBlog(Long id);

    Long createBlog(BlogInfo blogInfo);

    void updateBlog(BlogInfo blogInfo, Long blogId);

    String getAbsoluteFilePath(Long blogId);


    String getThumbnail(Long blogId);

    void deleteBlog(Long blogId);
}
