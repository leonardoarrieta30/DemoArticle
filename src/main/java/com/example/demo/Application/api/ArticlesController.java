package com.example.demo.Application.api;

import com.example.demo.Application.domain.service.ArticleService;
import com.example.demo.Application.mapping.ArticleMapper;
import com.example.demo.Application.resource.Article.ArticleResource;
import com.example.demo.Application.resource.Article.CreateArticleResource;
import com.example.demo.Application.resource.Article.UpdateArticleResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/articles", produces = "application/json")
@Tag(name = "Articles", description = "Create, read, update and delete articles")
public class ArticlesController {

    private final ArticleService articleService;
    private final ArticleMapper mapper;

    public ArticlesController(ArticleService articleService, ArticleMapper mapper) {
        this.articleService = articleService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ArticleResource> getAllArticles(Pageable pageable) {
        return mapper.modelListPage(articleService.getAll(), pageable);
    }


    @GetMapping("{articleId}")
    public ArticleResource getArticleById(@PathVariable Long articleId){
        return mapper.toResource(articleService.getById(articleId));
    }

    @GetMapping("articles/v2/{categoryId}")
    public Page<ArticleResource> getArticlesByCategoryId(@PathVariable Long categoryId, Pageable pageable){
        return mapper.modelListPage(articleService.getArticlesByCategoryId(categoryId), pageable);
    }



    @GetMapping("/article")
    public Page<ArticleResource> getArticlesByName(@RequestParam("articleName") String articleName, Pageable pageable){
        return mapper.modelListPage(articleService.getArticlesByName(articleName), pageable);
    }


    @PostMapping
    public ResponseEntity<ArticleResource> createArticle(@RequestBody CreateArticleResource resource){
        return new ResponseEntity<>(mapper.toResource(articleService.create(resource)), HttpStatus.CREATED);
    }

    @PutMapping("{articleId}")
    public ArticleResource updateArticle(@PathVariable Long articleId, @RequestBody UpdateArticleResource resource){
        return mapper.toResource(articleService.update(articleId,mapper.toModel(resource)));
    }


    @DeleteMapping("{articleId}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long articleId){
        return articleService.delete(articleId);
    }


}
