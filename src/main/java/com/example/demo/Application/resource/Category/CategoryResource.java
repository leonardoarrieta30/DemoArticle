package com.example.demo.Application.resource.Category;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResource {

    private Long id;

    private String name;

    private String description;

    private String Image;
}
