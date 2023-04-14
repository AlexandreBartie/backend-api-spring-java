package br.com.bartie.app.serialization;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class DataMapper {

	private static ModelMapper model = new ModelMapper();    
	
	public static <O, D> D parse(O origin, Class<D> destination) {
		return model.map(origin, destination);
	}
	
	public static <O, D> List<D> parse(List<O> origin, Class<D> destination) {
		List<D> list = new ArrayList<D>();
		for (O item : origin) {
			list.add(model.map(item, destination));
		}
		return list;
	}

}
