package com.bizremark.blogs.blog.model.repository;

import com.bizremark.blogs.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogJpaRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
    List<Blog> getBlogsByUserId(Integer userId);

    Page<Blog> getBlogsByUserUsername(String username, Pageable pageable);
}
