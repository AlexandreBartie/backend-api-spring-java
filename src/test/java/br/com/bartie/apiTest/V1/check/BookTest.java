package br.com.bartie.apiTest.V1.check;

import static org.junit.jupiter.api.Assertions.*;

import br.com.bartie.apiTest.core.ModelUnitTest;
import br.com.bartie.api.v1.dto.BookDTO;
import br.com.bartie.apiTest.V1.data.BookData;
import br.com.bartie.apiTest.V1.mock.BookMock;

import br.com.bartie.data.model.Book;

public class BookTest extends ModelUnitTest<Book, BookDTO> {
 
    public BookTest()
    { super(new BookMock());}

    public void check(Book Book)
    {

        Long id = Book.getId();

        assertNotNull(Book);
        
        assertEquals(id, Book.getId());
        assertEquals(BookData.getAuthor(id), Book.getAuthor());
        assertEquals(BookData.getTitle(id), Book.getTitle());
        assertEquals(BookData.getPrice(id), Book.getPrice());
        assertEquals(BookData.getLaunch(id), Book.getLaunch());

    }

    public void checkDTO(BookDTO Book)
    {

        Long id = Book.getId();
     
        assertEquals(id, Book.getId());
        assertEquals(BookData.getAuthor(id), Book.getAuthor());
        assertEquals(BookData.getTitle(id), Book.getTitle());
        assertEquals(BookData.getPrice(id), Book.getPrice());
        assertEquals(BookData.getLaunch(id), Book.getLaunch());

    }


}
