package com.example.demo.Application.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("applicationMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ArticleMapper articleMapper(){
        return new ArticleMapper();
    }
    @Bean
    public CategoryMapper categoryMapper(){
        return new CategoryMapper();
    }
}
