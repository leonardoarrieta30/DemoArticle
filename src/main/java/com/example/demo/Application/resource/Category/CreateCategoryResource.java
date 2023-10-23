package com.example.demo.Application.resource.Category;


import lombok.*;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryResource {


    private String name;

    private String description;

    private String Image;
}
