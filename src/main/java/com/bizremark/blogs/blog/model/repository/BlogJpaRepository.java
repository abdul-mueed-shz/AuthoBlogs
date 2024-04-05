package com.bizremark.blogs.blog.model.repository;

import com.bizremark.blogs.blog.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogJpaRepository extends JpaRepository<Blog, Long> {
}
