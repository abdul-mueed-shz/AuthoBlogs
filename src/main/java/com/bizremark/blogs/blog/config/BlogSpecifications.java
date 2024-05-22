package com.bizremark.blogs.blog.config;

import com.bizremark.blogs.blog.model.entity.Blog;
import org.springframework.data.jpa.domain.Specification;

public class BlogSpecifications {

    private BlogSpecifications() {
    }

    public static Specification<Blog> hasUsername(String username) {
        return (root, query, criteriaBuilder) -> {
            if (username == null || username.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("user").get("username"), "%" + username + "%");
        };
    }

    public static Specification<Blog> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> {
            if (title == null || title.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%");
        };
    }

    public static Specification<Blog> hasDescription(String description) {
        return (root, query, criteriaBuilder) -> {
            if (description == null || description.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("description"), "%" + description + "%");
        };
    }

    // Add more specifications as needed
}