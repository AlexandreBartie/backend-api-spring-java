package br.com.bartie.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean    
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Spring Boot-Server RESTful Api")
                .version("v1")
                .description("Create by Java, Spring Boot, Hibernate and RESTful concepts.")
                .termsOfService("https://github.com/AlexandreBartie")
                .license(new License().name("MIT").url("https://github.com/AlexandreBartie"))
            );     
    }

    
}
