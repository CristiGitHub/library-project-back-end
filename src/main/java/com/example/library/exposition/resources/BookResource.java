package com.example.library.exposition.resources;

import com.example.library.domain.model.Book;
import com.example.library.exposition.ICommand.ICommand;
import com.example.library.exposition.IQuerry.IQuerry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/api/v1/book" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class BookResource {

    @Autowired
    private ICommand<Book> bookICommand;
    @Autowired
    private IQuerry<Book> bookIQuerry;


    @PostMapping("")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) throws Exception{
        String id= bookICommand.save(book);
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + id).toUriString();
        return ResponseEntity.created(new URI(uri))
                .body(bookIQuerry.getById(id));
    }

    @PutMapping(path = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(@PathVariable("id") String id , @RequestBody Book book){
       String objectId= bookICommand.update(book,id);
        return ResponseEntity.ok()
                .body(bookIQuerry.getById(objectId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id){
        return ResponseEntity.ok()
                .body(bookIQuerry.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") String id){
        bookICommand.delete(id);
        return ResponseEntity.ok().build();
    }
}
