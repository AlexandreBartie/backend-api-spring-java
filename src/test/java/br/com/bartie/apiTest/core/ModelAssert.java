package br.com.bartie.apiTest.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import br.com.bartie.app.core.ModelDTO;
import br.com.bartie.app.core.ModelEntity;

public abstract class ModelAssert<T extends ModelEntity, DTO extends ModelDTO<DTO>> {

    public abstract void check(T item);

    public abstract void checkDTO(DTO item);

    public void checkList(List<DTO> list, int size)    
    {

        assertNotNull(list);
        assertEquals(size, list.size());

        list.stream().forEach(item -> checkService(item));

    }

    public void checkService(DTO item)
    {

        Long id = item.getId();

        checkDTO(item);

        assertTrue(item.hasLinks(),"Link HATEOAS not found!");
        assertEquals(String.format("</person/v1/%s>;rel=\"self\"", id), item.getApiLinks());

    }

    
    public void checkIsNullException(Exception output)
    {
        assertEquals("it is not allowed to persist a null object!", output.getMessage());    
    }
}
