package com.example.demo.Application.domain.persistence;

import com.example.demo.Application.domain.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> getArticlesByCategoryId(Long categoryId);
    List<Article> getArticlesByName(String articleName);

}
