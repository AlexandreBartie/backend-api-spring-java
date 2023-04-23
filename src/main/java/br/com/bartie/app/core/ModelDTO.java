package br.com.bartie.app.core;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ModelDTO<DTO extends RepresentationModel<? extends DTO>> extends RepresentationModel<DTO> implements Serializable {    

    private static final long serialVersionUID = 1L;

	public Long id;

    @JsonIgnore
	public String getApiLinks() { return getLinks().toString(); } 

    // @JsonIgnore
    // public Long getId() {
    //     return id;
    // }
    
    // @JsonIgnore
    // public void setId(Long id) {
    //     this.id = id;
    // }

}
