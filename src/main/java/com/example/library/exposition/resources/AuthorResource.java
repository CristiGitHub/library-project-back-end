package com.example.library.exposition.resources;

import com.example.library.domain.enums.BookGenreEnum;
import com.example.library.domain.model.Author;
import com.example.library.exposition.ICommand.ICommand;
import com.example.library.exposition.IQuerry.IQuerryAuthors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/author" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class AuthorResource {

    @Autowired
   private ICommand<Author> authorICommand;

    @Autowired
    private IQuerryAuthors authoriQuerry;

    @PostMapping("")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) throws Exception{
        String id= authorICommand.save(author);
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + id).toUriString();
        return ResponseEntity.created(new URI(uri))
                .body(authoriQuerry.getById(id));
    }

    @PutMapping(path = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") String id , @RequestBody Author author){
        String objectId= authorICommand.update(author,id);
        return ResponseEntity.ok()
                .body(authoriQuerry.getById(objectId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") String id){
        return ResponseEntity.ok()
                .body(authoriQuerry.getById(id));
    }

    @GetMapping("/{id}/genre")
    public ResponseEntity<BookGenreEnum> getFavouriteGenre(@PathVariable("id") String id){
        return ResponseEntity.ok().body(authoriQuerry.mostCommonGenre(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") String id){
        authorICommand.delete(id);
        return ResponseEntity.ok().build();
    }
}
