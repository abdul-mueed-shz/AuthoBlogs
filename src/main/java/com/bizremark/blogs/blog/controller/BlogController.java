package com.bizremark.blogs.blog.controller;

import com.bizremark.blogs.blog.dto.BlogDto;
import com.bizremark.blogs.blog.info.BlogInfo;
import com.bizremark.blogs.blog.info.BlogResponse;
import com.bizremark.blogs.blog.mapper.BlogDtoMapper;
import com.bizremark.blogs.blog.service.BlogService;
import com.bizremark.blogs.common.config.UserDetailService;
import com.bizremark.blogs.user.info.LoggedInUserInfo;
import com.bizremark.blogs.user.mapper.LoggedInUserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
    private final BlogDtoMapper blogDtoMapper;
    private final UserDetailService userDetailService;
    private final LoggedInUserMapper loggedInUserMapper;

    @GetMapping
    public ResponseEntity<List<BlogResponse>> getBlogs() {
        return ResponseEntity.ok(blogService.getBlogs());
    }

    @GetMapping(path = "{blogId}")
    public ResponseEntity<BlogResponse> getBlog(@PathVariable("blogId") Long blogId) {
        return ResponseEntity.ok(blogService.getBlog(blogId));
    }

    @PostMapping(consumes = "multipart/form-data")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createBlog(@Valid @ModelAttribute BlogDto blogDto) {
        LoggedInUserInfo loggedInUserInfo = userDetailService.getLoggedInUserInfo();
        BlogInfo blogInfo = blogDtoMapper.blogDtoToBlogInfo(blogDto);
        blogInfo.setUser(loggedInUserMapper.loggedInUserInfoToUser(loggedInUserInfo));
        blogService.createBlog(blogInfo, blogDto.getThumbnail());
    }

    @DeleteMapping(path = "{blogId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBlog(@PathVariable("blogId") Long blogId) {
        LoggedInUserInfo loggedInUserInfo = userDetailService.getLoggedInUserInfo();
        blogService.deleteBlog(blogId, loggedInUserInfo);
    }

    @PutMapping(path = "{blogId}", consumes = "multipart/form-data")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateBlog(@PathVariable("blogId") Long blogId, @Valid @ModelAttribute BlogDto blogDto) {
        LoggedInUserInfo loggedInUserInfo = userDetailService.getLoggedInUserInfo();
        BlogInfo blogInfo = blogDtoMapper.blogDtoToBlogInfo(blogDto);
        blogInfo.setUser(loggedInUserMapper.loggedInUserInfoToUser(loggedInUserInfo));
        blogService.updateBlog(blogId, blogInfo, blogDto.getThumbnail());
    }
}
