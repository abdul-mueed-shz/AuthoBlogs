package com.bizremark.blogs.blog.model.entity;

import com.bizremark.blogs.category.model.entity.Category;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Making the title mandatory
    private String title;

    private String description;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Foreign key
    private Category category;

    @Column(name="absolute_thumbnail_path")
    private String absolutePath;

    @Column(name="thumbnail_path")
    private String thumbnailPath;
}

