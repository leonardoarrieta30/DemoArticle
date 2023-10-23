package com.example.demo.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class OpenApiConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("https://demoapp-8aec6.web.app/").allowedMethods("*").allowedHeaders("*");
    }
    @Bean
    public OpenAPI customOpenAPi(

    ){
        return new OpenAPI()
                .info(new Info()
                        .title("DemoApp API")
                        .version("1.0.0")
                        .description("Aplicación de Omar")
                        .termsOfService("https://www.privacypolicies.com/live/0c6fe5e8-7fdc-4545-991a-da701a306903")
                        .license(new License().name("Apache 2.0 License").url("https://demoapp.com/license"))
                        .contact(new Contact().url("https://demoapp.com").name("Demo.APP")));
    }
}
