package br.com.bartie.api.v1.services;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.bartie.data.model.Book;
import br.com.bartie.data.repository.BookRepository;
import br.com.bartie.api.v1.controllers.BookController;
import br.com.bartie.api.v1.mapper.BookMapper;
import br.com.bartie.api.v1.view.BookDTO;
import br.com.bartie.app.core.ModelService;
import br.com.bartie.app.exceptions.RequiredObjectIsNullException;
import br.com.bartie.app.exceptions.ResourceNotFoundException;

@Service
public class BookServices extends ModelService {
 
    private Logger logger;

    private BookMapper mapper = new BookMapper();

    @Autowired
    BookRepository repository;

    public BookServices() {
        logger = Logger.getLogger(BookServices.class.getName());
    }

    public void log(String msg) {
        logger.info(msg);
    }

    public List<BookDTO> findAll() {

        log("Get all Books!");

        var list = mapper.parseDTO(repository.findAll());

        list.stream().forEach(item -> addLink(item));
  
        return list;

    }

    public BookDTO find(Long id) {
        
        Book item = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found!"));

        log("Get one Book! >> " + item.getAuthor());

        return addLink(mapper.parseDTO(item));

    }

    public BookDTO create(Book Book) {

        if (Book == null) throw new RequiredObjectIsNullException();

        log("Create one Book! >> " + Book.getAuthor());

        return addLink(mapper.parseDTO(repository.save(Book)));

    }

    public BookDTO create(BookDTO Book) {

        return create(mapper.parse(Book));
    }

    public BookDTO update(BookDTO Book) {
        
        return update(mapper.parse(Book));
    }

    public BookDTO update(Book Book) {
        
        if (Book == null) throw new RequiredObjectIsNullException();

        log("Update one Book! >> " + Book.getAuthor());

        return addLink(mapper.parseDTO(repository.save(Book)));

    }

    public void delete(BookDTO Book) {

        Book item = mapper.parse(Book);

        log("Update one Book! >> " + item.getAuthor());

        repository.delete(item);

    }

    public void delete(Long id) {

        BookDTO item = find(id);

        if (item != null)
        {
            delete(item);
        }

    }
        
    private BookDTO addLink(BookDTO item) { 
            
        Link link = getLink(WebMvcLinkBuilder.methodOn(BookController.class).find(item.getId())); 

        return item.add(link);
    }
   
}
