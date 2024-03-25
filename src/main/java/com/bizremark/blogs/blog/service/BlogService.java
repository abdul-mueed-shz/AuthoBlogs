package com.bizremark.blogs.blog.service;

import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;
import com.bizremark.blogs.blog.model.dao.BlogDao;
import com.bizremark.blogs.blog.model.entity.Blog;
import com.bizremark.blogs.category.model.dao.CategoryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogDao blogDao;
    private final CategoryDao categoryDao;

    public List<BlogResponse> getBlogs() {
        return blogDao.getAllBlogs();
    }

    public BlogResponse getBlog(Long blogId) {
        if (!blogDao.blogExists(blogId)) {
            throw new IllegalArgumentException("Blog with ID " + blogId + " does not exist");
        }
        return blogDao.getBlog(blogId);
    }

    public void createBlog(BlogInfo blogInfo) {
        Long categoryId = blogInfo.getCategory().getId();
        if (!categoryDao.doesCategoryExist(categoryId)) {
            throw new IllegalArgumentException("Category with ID " + categoryId + " does not exist");
        }
        blogDao.createBlog(blogInfo);
    }
}
