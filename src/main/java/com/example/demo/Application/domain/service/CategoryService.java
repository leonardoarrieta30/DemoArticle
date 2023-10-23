package com.example.demo.Application.domain.service;

import com.example.demo.Application.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Page<Category> getAll(Pageable pageable);

    Category getById(Long categoryId);


    Category create(Category category);

    Category update(Long categoryId, Category request);

    ResponseEntity<?> delete(Long categoryId);

}
