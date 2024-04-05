package com.bizremark.blogs.category.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    @NotNull(message = "Category name is required")
    @Size(max = 255, message = "Category name must be less than or equal to 255 characters")
    private String name;
}
