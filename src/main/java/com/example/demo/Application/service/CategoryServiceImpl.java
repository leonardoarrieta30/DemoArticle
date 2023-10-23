package com.example.demo.Application.service;

import com.example.demo.Application.domain.model.Category;
import com.example.demo.Application.domain.persistence.CategoryRepository;
import com.example.demo.Application.domain.service.CategoryService;
import com.example.demo.shared.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String ENTITY = "Category";
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, categoryId));
    }


    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long categoryId, Category request) {
        return categoryRepository.findById(categoryId).map(category ->
                categoryRepository.save(
                        category.withDescription(request.getDescription())
                                .withImage(request.getImage())
                                .withName(request.getName())
                )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, categoryId));
    }

    @Override
    public ResponseEntity<?> delete(Long categoryId) {
        return categoryRepository.findById(categoryId).map(category -> {
            categoryRepository.delete(category);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, categoryId));
    }
}
