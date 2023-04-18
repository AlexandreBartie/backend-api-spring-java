package br.com.bartie.api.v1.mapper;

import br.com.bartie.api.v1.view.BookDTO;
import br.com.bartie.app.serialization.DataMapper;
import br.com.bartie.data.model.Book;

import java.util.List;

public class BookMapper {

    public static Book parse(BookDTO source) {
        return DataMapper.parse(source, Book.class);
    }

    public static List<Book> parse(List<BookDTO> source) {
        return DataMapper.parse(source, Book.class);
    }

    public static BookDTO parseDTO(Book source) {
        return DataMapper.parse(source, BookDTO.class);
    }

    public static List<BookDTO> parseDTO(List<Book> source) {
        return DataMapper.parse(source, BookDTO.class);
    }

}
