package com.bizremark.blogs.blog.model.dao;

import com.bizremark.blogs.blog.config.BlogSpecifications;
import com.bizremark.blogs.blog.dto.BlogFilterDto;
import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;
import com.bizremark.blogs.blog.mapper.BlogInfoMapper;
import com.bizremark.blogs.blog.model.entity.Blog;
import com.bizremark.blogs.blog.model.repository.BlogJpaRepository;
import com.bizremark.blogs.blog.model.repository.BlogRepository;
import com.bizremark.blogs.common.dto.PageRequestDto;
import com.bizremark.blogs.common.service.PaginationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BlogDao implements BlogRepository {
    private final BlogJpaRepository blogRepository;
    private final BlogInfoMapper blogInfoMapper;
    private final PaginationHelper paginationHelper;

    public Boolean blogExists(Long id) {
        return blogRepository.existsById(id);
    }

    public Page<BlogResponse> getAllBlogs(BlogFilterDto filterDto, PageRequestDto pageRequestDto) {
        Pageable pageable = paginationHelper.map(pageRequestDto);

        Specification<Blog> specs = Specification
                .where(BlogSpecifications.hasUsername(filterDto.getUsername()))
                .and(BlogSpecifications.hasTitle(filterDto.getTitle()))
                .and(BlogSpecifications.hasDescription(filterDto.getDescription()));

        Page<Blog> blogPage = blogRepository.findAll(specs, pageable);
        return paginationHelper.mapPageEntitiesToInfos(blogPage, blogInfoMapper::blogToBlogResponse);
    }

    public BlogResponse getBlog(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        return blog.map(blogInfoMapper::blogToBlogResponse).orElse(null);
    }

    public Page<BlogResponse> getUserBlogs(String username, PageRequestDto pageRequestDto) {
        Pageable pageable = paginationHelper.map(pageRequestDto);
        Page<Blog> blogPage = blogRepository.getBlogsByUserUsername(username, pageable);
        return paginationHelper.mapPageEntitiesToInfos(blogPage, blogInfoMapper::blogToBlogResponse);
    }

    public Long createBlog(BlogInfo blogInfo) {
        Blog blog = blogInfoMapper.blogInfoToBlog(blogInfo);
        blog = blogRepository.save(blog);
        return blog.getId();
    }

    public void updateBlog(BlogInfo blogInfo, Long blogId) {
        Blog blog = blogInfoMapper.blogInfoToBlog(blogInfo);
        blog.setId(blogId);
        blogRepository.save(blog);
    }

    public String getAbsoluteFilePath(Long blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        return blog.map(Blog::getAbsolutePath).orElse(null);
    }


    public String getThumbnail(Long blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        return blog.map(Blog::getThumbnailPath).orElse(null);
    }

    public void deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);
    }

}
