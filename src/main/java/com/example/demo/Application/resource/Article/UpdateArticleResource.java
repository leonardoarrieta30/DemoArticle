package com.example.demo.Application.resource.Article;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateArticleResource {

    private Long id;

    private String code;
    private String name;
    private String description;

    private Double price;

    private Integer stock;

    private String photo;

    private Boolean state;
}
