package br.com.bartie.app.config;

import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //
    // Via QUERY PARAMETER
    // http: //localhost:8080/api/person/v1/1?mediaType=xml
    //
    // @Override
    // public void configureContentNegotiation(ContentNegotiationConfigurer
    // configurer) {
    //
    // configurer
    // .favorParameter(true)
    // .parameterName("mediaType")
    // .ignoreAcceptHeader(true)
    // .useRegisteredExtensionsOnly(false)
    // .defaultContentType(MediaType.APPLICATION_JSON)
    // .mediaType("json", MediaType.APPLICATION_JSON)
    // .mediaType("xml", MediaType.APPLICATION_XML);
    //
    // }

    //
    // Via HEADER PARAMETER
    // http: //localhost:8080/api/person/v1/p
    //
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }

}
