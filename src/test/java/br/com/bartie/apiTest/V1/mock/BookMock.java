package br.com.bartie.apiTest.V1.mock;

import java.util.Date;

import br.com.bartie.app.core.ModelMock;

import br.com.bartie.api.v1.view.BookDTO;
import br.com.bartie.data.model.Book;

public class BookMock extends ModelMock<Book, BookDTO> {

    public Book mockEntity(Long number) {
        Book Book = new Book();
        Book.setId(number.longValue());
        Book.setTitle("Title " + number);
        Book.setAuthor("Author " + number);
        Book.setPrice(number.doubleValue());
        Book.setLaunch(new Date());
        return Book;
    }

    public BookDTO mockDTO(Long number) {
        BookDTO Book = new BookDTO();
        Book.setId(number.longValue());
        Book.setTitle("Title " + number);
        Book.setAuthor("Author " + number);
        Book.setPrice(number.doubleValue());
        Book.setLaunch(new Date());
        return Book;
    }

}
