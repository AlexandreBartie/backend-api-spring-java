package br.com.bartie.apiTest.unitTest.V1.mock;

import br.com.bartie.app.core.ModelMock;
import br.com.bartie.api.v1.dto.BookDTO;
import br.com.bartie.apiTest.unitTest.V1.data.BookData;
import br.com.bartie.data.model.Book;

public class BookMock extends ModelMock<Book, BookDTO> {

    public BookMock()
    {
        super("book");
    }
    
    public Book mockEntity(Long number) {
        Book Book = new Book();
        Book.setId(number);
        Book.setAuthor(BookData.getAuthor(number));
        Book.setTitle(BookData.getTitle(number));
        Book.setPrice(BookData.getPrice(number));
        Book.setLaunch(BookData.getLaunch(number));
        return Book;
    }

    public BookDTO mockDTO(Long number) {
        BookDTO Book = new BookDTO();
        Book.setId(number);
        Book.setAuthor(BookData.getAuthor(number));
        Book.setTitle(BookData.getTitle(number));
        Book.setPrice(BookData.getPrice(number));
        Book.setLaunch(BookData.getLaunch(number));
        return Book;
    }

}
