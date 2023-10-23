package com.example.demo.Application.api;

import com.example.demo.Application.domain.service.CategoryService;
import com.example.demo.Application.mapping.CategoryMapper;
import com.example.demo.Application.resource.Category.CategoryResource;
import com.example.demo.Application.resource.Category.CreateCategoryResource;
import com.example.demo.Application.resource.Category.UpdateCategoryResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/categories", produces = "application/json")
@Tag(name = "Categories", description = "Create, read, update and delete categories")
public class CategoriesController {
    private final CategoryService categoryService;
    private final CategoryMapper mapper;

    public CategoriesController(CategoryService categoryService, CategoryMapper mapper) {
        this.categoryService = categoryService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<CategoryResource> getAllCategories(Pageable pageable) {
        return mapper.modelListPage(categoryService.getAll(), pageable);
    }


    @GetMapping("{categoryId}")
    public CategoryResource getCategoryById(@PathVariable Long categoryId){
        return mapper.toResource(categoryService.getById(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryResource> createCategory(@RequestBody CreateCategoryResource resource){
        return new ResponseEntity<>(mapper.toResource(categoryService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{categoryId}")
    public CategoryResource updateCategory(@PathVariable Long categoryId, @RequestBody UpdateCategoryResource resource){
        return mapper.toResource(categoryService.update(categoryId, mapper.toModel(resource)));
    }


    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId){
        return categoryService.delete(categoryId);
    }

}
