package com.example.demo.Application.domain.service;

import com.example.demo.Application.domain.model.Article;
import com.example.demo.Application.resource.Article.CreateArticleResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();

    Page<Article> getAll(Pageable pageable);

    Article getById(Long articleId);


    List<Article> getArticlesByCategoryId(Long categoryId);


    List<Article> getArticlesByName(String articleName);


    Article create(CreateArticleResource articleRequest);

    Article update(Long articleId, Article request);

    ResponseEntity<?> delete(Long articleId);
}
