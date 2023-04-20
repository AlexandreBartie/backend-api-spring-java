package br.com.bartie.app.core;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ModelEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;

}
