package br.com.bartie.api.v1.controllers;

import br.com.bartie.api.v1.dto.BookDTO;
import br.com.bartie.api.v1.services.BookServices;
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
@RequestMapping("/book/v1")
@Tag(name = "Book", description = "Endpoints of people information")
public class BookController {

    @Autowired
    private BookServices service;

    @Operation(summary = "Find all Book", tags = { "Book" },
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = { 
                    @Content(
                        mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = BookDTO.class)))
                 }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })               
    @GetMapping(
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public List<BookDTO> findAll() {  
        return service.findAll();
    }

    @Operation(summary = "Find a Book", tags = { "Book" },
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = { @Content(schema = @Schema(implementation = BookDTO.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })    
    @GetMapping(value = "/{id}", 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public BookDTO find(@PathVariable(value = "id") Long id) {
        return service.find(id);
    }

    @Operation(summary = "Add new Book", description = "Add new Book using JSON, XML or YML layouts", tags = { "Book" },
        responses = {
            @ApiResponse(description = "Created", responseCode = "200",
                content = { @Content(schema = @Schema(implementation = BookDTO.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })
    @PostMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }) 
    public BookDTO create(@RequestBody BookDTO Book) {
        return service.create(Book);
    }

    @Operation(summary = "Update Book", description = "Update Book using JSON, XML or YML layouts", tags = { "Book" },
        responses = {
            @ApiResponse(description = "Updated", responseCode = "200",
                content = { @Content(schema = @Schema(implementation = BookDTO.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Not Found", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),                                    
            })
    @PutMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public BookDTO update(@RequestBody BookDTO Book) {
        return service.update(Book);
    }

    @Operation(summary = "Delete Book", description = "Delete Book using JSON, XML or YML layouts", tags = { "Book" },
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


