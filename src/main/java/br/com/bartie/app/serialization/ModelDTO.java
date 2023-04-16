package br.com.bartie.app.serialization;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ModelDTO<DTO extends RepresentationModel<? extends DTO>> extends RepresentationModel<DTO> implements Serializable {    

    private static final long serialVersionUID = 1L;

	protected Long id;

    @JsonIgnore
	public String getApiLinks() { return getLinks().toString(); } 
	
}
