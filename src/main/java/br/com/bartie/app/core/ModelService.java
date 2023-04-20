package br.com.bartie.app.core;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class ModelService {

        public Link getLink(Object method) {

        return WebMvcLinkBuilder.linkTo(method).withSelfRel();
    }
}

    //     <Repo extends ModelRepository<T>, 
    //     Mapper extends ModelMapper<T,DTO>, 
    //     T extends ModelEntity, DTO> {

    // private Logger logger;

    // @Autowired
    // protected Repo repository;

    // public ModelService(String name) {
    //     logger = Logger.getLogger(name);
    // }

    // public void log(String msg) {
    //     logger.info(msg);
    // }

    // public List<DTO> findAll() {

    //     log("Get all persons!");

    //     var list = Mapper.parseDTO(repository.findAll());

    //     list.stream().forEach(item -> addLink(item));
  
    //     return list;

    // }

    // public PersonDTO find(Long id) {
        
    //     Person item = repository.findById(id)
    //     .orElseThrow(() -> new ResourceNotFoundException("No record found!"));

    //     log("Get one person! >> " + item.getFullName());

    //     return addLink(PersonMapper.parseDTO(item));

    // }

    // public PersonDTO create(Person person) {

    //     if (person == null) throw new RequiredObjectIsNullException();

    //     log("Create one person! >> " + person.getFullName());

    //     return addLink(PersonMapper.parseDTO(repository.save(person)));

    // }

    // public PersonDTO create(PersonDTO person) {

    //     return create(PersonMapper.parse(person));
    // }

    // public PersonDTO update(PersonDTO person) {
        
    //     return update(PersonMapper.parse(person));
    // }

    // public PersonDTO update(Person person) {
        
    //     if (person == null) throw new RequiredObjectIsNullException();

    //     log("Update one person! >> " + person.getFullName());

    //     return addLink(PersonMapper.parseDTO(repository.save(person)));

    // }

    // public void delete(PersonDTO person) {

    //     Person item = PersonMapper.parse(person);

    //     log("Update one person! >> " + item.getFullName());

    //     repository.delete(item);

    // }

    // public void delete(Long id) {

    //     PersonDTO item = find(id);

    //     if (item != null)
    //     {
    //         delete(item);
    //     }

    // }
        
    // private PersonDTO addLink(PersonDTO item) { 
            
    //     Link link = getLink(WebMvcLinkBuilder.methodOn(PersonController.class).find(item.getId())); 

    //     return item.add(link);
    // }



