package com.example.demo.Application.mapping;

import com.example.demo.Application.domain.model.Category;
import com.example.demo.Application.resource.Category.CategoryResource;
import com.example.demo.Application.resource.Category.CreateCategoryResource;
import com.example.demo.Application.resource.Category.UpdateCategoryResource;
import com.example.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CategoryMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public CategoryResource toResource(Category model){
        return mapper.map(model, CategoryResource.class);
    }

    public Category toModel(CreateCategoryResource resource){
        return mapper.map(resource, Category.class);
    }

    public Category toModel(UpdateCategoryResource resource){
        return mapper.map(resource, Category.class);
    }

    public Page<CategoryResource> modelListPage(List<Category> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, CategoryResource.class), pageable, modelList.size());
    }
}
