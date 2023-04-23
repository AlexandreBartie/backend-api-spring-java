package br.com.bartie.app.core;

import java.util.ArrayList;
import java.util.List;

public abstract class ModelMock<T extends ModelEntity, DTO> {
    
    public final String route;
    public final String version;

    public ModelMock(String route)
    {
        this.route = route;
        this.version = "v1";
    }

    public ModelMock(String route, String version)
    {
        this.route = route;
        this.version = version;
    }

    public T get(Long id) {
        return mockEntity(id);
    }

    public DTO getDTO(Long id) {
        return mockDTO(id);
    }

    public List<T> getList() {
        return getList(15);
    }

    public List<T> getList(int size) {
        List<T> persons = new ArrayList<T>();
        for (Long id = 1L; id <= size; id++) {
            persons.add(mockEntity(id));
        }
        return persons;
    }

    public List<DTO> getListDTO() {
        return getListDTO(15);
    }

    public List<DTO> getListDTO(int size) {
        List<DTO> persons = new ArrayList<>();
        for (Long id = 1L; id <= size; id++) {
            persons.add(mockDTO(id));
        }
        return persons;
    }

    public abstract T mockEntity(Long number);

    public abstract DTO mockDTO(Long number);

}




