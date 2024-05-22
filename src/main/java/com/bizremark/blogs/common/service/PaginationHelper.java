package com.bizremark.blogs.common.service;

import com.bizremark.blogs.common.dto.PageRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class PaginationHelper {
    public Pageable map(PageRequestDto pageRequest) {
        Sort sort;
        if (pageRequest.getSortBy().startsWith("-")) {
            sort = Sort.by(pageRequest.getSortBy().substring(1)).descending();
        } else {
            sort = Sort.by(pageRequest.getSortBy());
        }
        return PageRequest.of(pageRequest.getPage(), pageRequest.getSize(), sort);
    }

    public <T, R> Page<R> mapPageEntitiesToInfos(Page<T> page, Function<T, R> entityToInfoMapper) {
        return page.map(entityToInfoMapper);
    }
}
