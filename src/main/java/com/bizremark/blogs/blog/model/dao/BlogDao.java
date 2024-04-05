package com.bizremark.blogs.blog.model.dao;

import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;
import com.bizremark.blogs.blog.mapper.BlogInfoMapper;
import com.bizremark.blogs.blog.model.entity.Blog;
import com.bizremark.blogs.blog.model.repository.BlogRepository;
import com.bizremark.blogs.category.model.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BlogDao {
    private final BlogRepository blogRepository;
    private final BlogInfoMapper blogInfoMapper;

    public Boolean blogExists(Long id) {
        return blogRepository.existsById(id);
    }

    public List<BlogResponse> getAllBlogs() {
        List<Blog> blogList = blogRepository.findAll();
        return blogInfoMapper.blogListToBlogResponseList(blogList);
    }

    public BlogResponse getBlog(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        return blog.map(blogInfoMapper::blogToBlogResponse).orElse(null);
    }

    public Long createBlog(BlogInfo blogInfo) {
        Blog blog = blogInfoMapper.blogInfoToBlog(blogInfo);
        blog = blogRepository.save(blog);
        return blog.getId();
    }

}
