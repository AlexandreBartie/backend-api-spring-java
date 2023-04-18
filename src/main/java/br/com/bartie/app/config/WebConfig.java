package br.com.bartie.app.config;

import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.bartie.app.serialization.YAMLConverter;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
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

    private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YAMLConverter());
    }

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
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("yml", MEDIA_TYPE_APPLICATION_YML);
    }

}
