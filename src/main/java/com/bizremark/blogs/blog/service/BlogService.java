package com.bizremark.blogs.blog.service;

import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;
import com.bizremark.blogs.blog.model.dao.BlogDao;
import com.bizremark.blogs.category.model.dao.CategoryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogDao blogDao;
    private final CategoryDao categoryDao;

    private final HandleFileUpload handleThumbnailUploadService;

    public List<BlogResponse> getBlogs() {
        return blogDao.getAllBlogs();
    }

    public BlogResponse getBlog(Long blogId) {
        if (Boolean.FALSE.equals(blogDao.blogExists(blogId))) {
            throw new IllegalArgumentException("Blog with ID " + blogId + " does not exist");
        }
        return blogDao.getBlog(blogId);
    }

    @Transactional
    public void createBlog(BlogInfo blogInfo, MultipartFile file) {
        Long categoryId = blogInfo.getCategory().getId();
        if (Boolean.FALSE.equals(categoryDao.doesCategoryExist(categoryId))) {
            throw new IllegalArgumentException("Category with ID " + categoryId + " does not exist");
        }
        Long blogId = blogDao.createBlog(blogInfo);
        String fileName = file.getOriginalFilename();
        blogInfo.setId(blogId);
        blogInfo.setAbsolutePath(handleThumbnailUploadService.uploadFile(file, fileName, blogId));
        blogInfo.setThumbnailPath(handleThumbnailUploadService.getFileUrl(blogId, fileName));
        blogDao.createBlog(blogInfo);
    }

//
}
