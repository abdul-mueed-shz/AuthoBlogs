package com.bizremark.blogs.category.config;

import com.bizremark.blogs.category.model.entity.Category;
import org.springframework.data.jpa.domain.Specification;

public class CategorySpecifications {
    private CategorySpecifications() {
    }

    public static Specification<Category> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
        };
    }
}
