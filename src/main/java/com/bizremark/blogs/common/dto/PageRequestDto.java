package com.bizremark.blogs.common.dto;

import lombok.Data;

@Data
public class PageRequestDto {
    private int page = 0;
    private int size = 10;
    private String sortBy = "id";
}
