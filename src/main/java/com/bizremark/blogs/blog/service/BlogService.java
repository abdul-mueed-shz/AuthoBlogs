package com.bizremark.blogs.blog.service;

import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;
import com.bizremark.blogs.blog.mapper.BlogInfoMapper;
import com.bizremark.blogs.blog.model.dao.BlogDao;
import com.bizremark.blogs.category.model.dao.CategoryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogDao blogDao;
    private final CategoryDao categoryDao;

    private final BlogInfoMapper blogInfoMapper;

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
        if (Boolean.TRUE.equals(Objects.isNull(file))) {
            throw new IllegalArgumentException("Thumbnail is required");
        }
        Long blogId = blogDao.createBlog(blogInfo);
        saveThumbnail(file, blogId, blogInfo);
        blogDao.updateBlog(blogInfo, blogId);
    }

    @Transactional
    public void updateBlog(Long blogId, BlogInfo blogInfo, MultipartFile file) {
        if (Boolean.FALSE.equals(blogDao.blogExists(blogId))) {
            throw new IllegalArgumentException("Blog with ID " + blogId + " does not exist");
        }
        String absoluteThumbnailPath = blogDao.getAbsoluteFilePath(blogId);
        if (Boolean.FALSE.equals(Objects.isNull(file))) {
            handleThumbnailUploadService.deleteFile(absoluteThumbnailPath);
            saveThumbnail(file, blogId, blogInfo);
            blogDao.updateBlog(blogInfo, blogId);
            return;
        }
        blogInfo.setAbsolutePath(absoluteThumbnailPath);
        blogInfo.setThumbnailPath(blogDao.getThumbnail(blogId));
        blogDao.updateBlog(blogInfo, blogId);
    }

    @Transactional
    public void deleteBlog(Long blogId) {
        if (Boolean.FALSE.equals(blogDao.blogExists(blogId))) {
            throw new IllegalArgumentException("Blog with ID " + blogId + " does not exist");
        }
        String absoluteThumbnailPath = blogDao.getAbsoluteFilePath(blogId);
        if (Boolean.TRUE.equals(handleThumbnailUploadService.deleteFile(absoluteThumbnailPath))) {
            blogDao.deleteBlog(blogId);
            return;
        }
        throw new ApplicationContextException("Unable to delete blog");
    }

    private void saveThumbnail(MultipartFile file, Long blogId, BlogInfo blogInfo) {
        String fileName = file.getOriginalFilename();
        blogInfo.setAbsolutePath(handleThumbnailUploadService.uploadFile(file, fileName, blogId));
        blogInfo.setThumbnailPath(handleThumbnailUploadService.getFileUrl(blogId, fileName));
    }
}
