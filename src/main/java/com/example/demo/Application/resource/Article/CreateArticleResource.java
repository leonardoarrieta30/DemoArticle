package com.example.demo.Application.resource.Article;


import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateArticleResource {

    private String code;
    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private String photo;

    private Boolean state;

    private Long categoryId;
}
