package com.bizremark.blogs.category.model.repository;

import com.bizremark.blogs.category.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
}
