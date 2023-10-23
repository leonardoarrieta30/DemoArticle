package com.example.demo.Application.service;

import com.example.demo.Application.domain.model.Article;
import com.example.demo.Application.domain.model.Category;
import com.example.demo.Application.domain.persistence.ArticleRepository;
import com.example.demo.Application.domain.persistence.CategoryRepository;
import com.example.demo.Application.domain.service.ArticleService;
import com.example.demo.Application.resource.Article.CreateArticleResource;
import com.example.demo.shared.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final String ENTITY = "Article";
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public Page<Article> getAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article getById(Long articleId) {
        return articleRepository.findById(articleId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, articleId));
    }

    @Override
    public List<Article> getArticlesByCategoryId(Long categoryId) {
        return articleRepository.getArticlesByCategoryId(categoryId);
    }
    @Override
    public List<Article> getArticlesByName(String articleName) {
        return articleRepository.getArticlesByName(articleName);
    }


    @Override
    public Article create(CreateArticleResource articleRequest) {
        Category category = categoryRepository.findById(articleRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("La categoría no existe"));

        Article nuevoArticulo = new Article();
        nuevoArticulo.setCode(articleRequest.getCode());
        nuevoArticulo.setName(articleRequest.getName());
        nuevoArticulo.setDescription(articleRequest.getDescription());
        nuevoArticulo.setPrice(articleRequest.getPrice());
        nuevoArticulo.setStock(articleRequest.getStock());
        nuevoArticulo.setPhoto(articleRequest.getPhoto());
        nuevoArticulo.setState(articleRequest.getState());
        nuevoArticulo.setCategory(category);


        return articleRepository.save(nuevoArticulo);
    }

    @Override
    public Article update(Long articleId, Article request) {
        return articleRepository.findById(articleId).map( article ->
                articleRepository.save(
                        article.withCode(request.getCode())
                                .withName(request.getName())
                                .withDescription(request.getDescription())
                                .withState(request.getState())
                                .withPrice(request.getPrice())
                                .withPhoto(request.getPhoto())
                                .withStock(request.getStock())
                )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, articleId));
    }

    @Override
    public ResponseEntity<?> delete(Long articleId) {
        return articleRepository.findById(articleId).map( article -> {
            articleRepository.delete(article);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, articleId));
    }
}
