package br.com.bartie.api.v2.controllers;

import br.com.bartie.api.v2.services.PersonServicesV2;
import br.com.bartie.api.v2.view.PersonDTO;
import br.com.bartie.app.serialization.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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
@RequestMapping("/person/v2")
@Tag(name = "Person", description = "Endpoints of people information")
public class PersonControllerV2 {

    @Autowired
    private PersonServicesV2 service;

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
    @GetMapping(
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public List<PersonDTO> findAll() {  
        return service.findAll();
    }

    @Operation(summary = "Find a Person", tags = { "Person" },
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = { @Content(schema = @Schema(implementation = PersonDTO.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })    
    @GetMapping(value = "/{id}", 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
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
    @PostMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }) 
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @Operation(summary = "Update Person", description = "Update Person using JSON, XML or YML layouts", tags = { "Person" },
        responses = {
            @ApiResponse(description = "Updated", responseCode = "200",
                content = { @Content(schema = @Schema(implementation = PersonDTO.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })
    @PutMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }

    @Operation(summary = "Delete Person", description = "Delete Person using JSON, XML or YML layouts", tags = { "Person" },
        responses = {
            @ApiResponse(description = "No Content", responseCode = "204", content = { @Content }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })      

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}


