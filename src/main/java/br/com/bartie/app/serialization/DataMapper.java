package br.com.bartie.app.serialization;

// import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;

public class DataMapper<T, DTO> {

	private static final ModelMapper model = new ModelMapper();

	public T parse(DTO source, Class<T> destination) {
		return model.map(source, destination);
	}

	public DTO parseDTO(T source, Class<DTO> destination) {
		return model.map(source, destination);
	}

	public List<T> parse(List<DTO> source, Class<T> destination) {
		List<T> list = new ArrayList<T>();
		for (DTO item : source) {
			list.add(model.map(item, destination));
		}
		return list;
	}

	public List<DTO> parseDTO(List<T> source, Class<DTO> destination) {
		List<DTO> list = new ArrayList<DTO>();
		for (T item : source) {
			list.add(model.map(item, destination));
		}
		return list;
	}

	// private Type getDestination() {
		
	// 	TypeToken<D> token = new TypeToken<D>() {};

	// 	return token.getType();
	// }

	// private Type getDestinationDTO() {
		
	// 	TypeToken<S> token = new TypeToken<S>() {};

	// 	return token.getType();
	// }

}
