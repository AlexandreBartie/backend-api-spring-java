package br.com.bartie.app.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public class YAMLConverter extends
        AbstractJackson2HttpMessageConverter {

    public YAMLConverter() {
        super(new YAMLMapper()
                .setSerializationInclusion(
                        JsonInclude.Include.NON_NULL),
                        MediaType.parseMediaType("application/x-yaml")
                );
    }

}
    

