package br.com.bartie.core;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class Mapper {
	
	private ModelMapper model = new ModelMapper();
	
	public <O, D> D parse(O origin, Class<D> destination) {
		return model.map(origin, destination);
	}
	
	public <O, D> List<D> parse(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		for (O o : origin) {
			destinationObjects.add(model.map(o, destination));
		}
		return destinationObjects;
	}

}
