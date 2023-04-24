package br.com.bartie.api.v1.controllers;

import br.com.bartie.api.v1.dto.PersonDTO;
import br.com.bartie.api.v1.services.PersonServices;
import br.com.bartie.app.serialization.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/person/v1")
@Tag(name = "Person", description = "Endpoints of people information")
public class PersonController {

    @Autowired
    private PersonServices service;
            
    @GetMapping(
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(summary = "Find all Person", tags = { "Person" },
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = { 
                    @Content(
                        mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))
                 }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })  
        public List<PersonDTO> findAll() {  
        return service.findAll();
    }
    
    @CrossOrigin(origins = "http:\\localhost:8080")
    @GetMapping(value = "/{id}", 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(summary = "Find a Person", tags = { "Person" },
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = { @Content(schema = @Schema(implementation = PersonDTO.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })  
    public PersonDTO find(@PathVariable(value = "id") Long id) {
        return service.find(id);
    }

    @Operation(summary = "Add new Person", description = "Add new Person using JSON, XML or YML layouts", tags = { "Person" },
        responses = {
            @ApiResponse(description = "Created", responseCode = "200",
                content = { @Content(schema = @Schema(implementation = PersonDTO.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })
            
    @CrossOrigin(origins = {"http://localhost:8080", "https://bartie.com.br"})
    @PostMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }) 
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PutMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(summary = "Update Person", description = "Update Person using JSON, XML or YML layouts", tags = { "Person" },
        responses = {
            @ApiResponse(description = "Updated", responseCode = "200",
                content = { @Content(schema = @Schema(implementation = PersonDTO.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete Person", description = "Delete Person using JSON, XML or YML layouts", tags = { "Person" },
        responses = {
            @ApiResponse(description = "No Content", responseCode = "204", content = { @Content }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })      
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}


