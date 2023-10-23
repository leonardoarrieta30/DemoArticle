package com.example.demo.Application.mapping;

import com.example.demo.Application.domain.model.Article;
import com.example.demo.Application.resource.Article.ArticleResource;
import com.example.demo.Application.resource.Article.CreateArticleResource;
import com.example.demo.Application.resource.Article.UpdateArticleResource;
import com.example.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ArticleMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ArticleResource toResource(Article model){
        return mapper.map(model, ArticleResource.class);
    }

    public Article toModel(CreateArticleResource resource){
        return mapper.map(resource, Article.class);
    }

    public Article toModel(UpdateArticleResource resource){
        return mapper.map(resource, Article.class);
    }

    public Page<ArticleResource> modelListPage(List<Article> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, ArticleResource.class), pageable, modelList.size());
    }


}
