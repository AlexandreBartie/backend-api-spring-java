package br.com.bartie.api.v1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.bartie.data.model.Book;
import br.com.bartie.data.repository.BookRepository;
import br.com.bartie.api.v1.controllers.BookController;
import br.com.bartie.api.v1.mapper.BookMapper;
import br.com.bartie.api.v1.view.BookDTO;
import br.com.bartie.app.core.ModelServices;
import br.com.bartie.app.exceptions.RequiredObjectIsNullException;
import br.com.bartie.app.exceptions.ResourceNotFoundException;


@Service
public class BookServices extends ModelServices<BookRepository> {
 
    public BookServices() {
        super(BookServices.class.getName());
    }

    public List<BookDTO> findAll() {

        log("Get all Books!");

        var list = BookMapper.parseDTO(repository.findAll());

        list.stream().forEach(item -> addLink(item));
  
        return list;

    }

    public BookDTO find(Long id) {
        
        Book item = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found!"));

        log("Get one Book! >> " + item.getTitle());

        return addLink(BookMapper.parseDTO(item));

    }

    public BookDTO create(Book Book) {

        if (Book == null) throw new RequiredObjectIsNullException();

        log("Create one Book! >> " + Book.getTitle());

        return addLink(BookMapper.parseDTO(repository.save(Book)));

    }

    public BookDTO create(BookDTO Book) {

        return create(BookMapper.parse(Book));
    }

    public BookDTO update(BookDTO Book) {
        
        return update(BookMapper.parse(Book));
    }

    public BookDTO update(Book Book) {
        
        if (Book == null) throw new RequiredObjectIsNullException();

        log("Update one Book! >> " + Book.getTitle());

        return addLink(BookMapper.parseDTO(repository.save(Book)));

    }

    public void delete(BookDTO Book) {

        Book item = BookMapper.parse(Book);

        log("Update one Book! >> " + item.getTitle());

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
