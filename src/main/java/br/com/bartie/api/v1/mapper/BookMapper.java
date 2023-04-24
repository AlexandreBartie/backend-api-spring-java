package br.com.bartie.api.v1.mapper;

import java.util.List;

import br.com.bartie.api.v1.dto.BookDTO;
import br.com.bartie.app.serialization.DataMapper;
import br.com.bartie.data.model.Book;

public class BookMapper { // extends ModelMapper<Book, BookDTO> {}

    private DataMapper<Book, BookDTO> mapper = new DataMapper<Book, BookDTO> ();

    public Book parse(BookDTO source) {
        return mapper.parse(source, Book.class);
    }

    public List<Book> parse(List<BookDTO> source) {
        return mapper.parse(source, Book.class);
	}

    public BookDTO parseDTO(Book source)
    {
        return mapper.parseDTO(source, BookDTO.class);
    }

    public List<BookDTO> parseDTO(List<Book> source) {
        return mapper.parseDTO(source, BookDTO.class);
	}

}

