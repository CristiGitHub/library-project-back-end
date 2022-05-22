package com.example.library.exposition.resources;

import com.example.library.domain.model.Section;
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
@RequestMapping(value = "/api/v1/section" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class SectionResource {

    @Autowired
    private ICommand<Section> sectionICommand;
    @Autowired
    private IQuerry<Section> sectionIQuerry;

    @PostMapping("")
    public ResponseEntity<Section> createSection(@RequestBody Section section) throws Exception{
        String id= sectionICommand.save(section);
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + id).toUriString();
        return ResponseEntity.created(new URI(uri))
                .body(sectionIQuerry.getById(id));
    }

    @PutMapping(path = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Section> updateSection(@PathVariable("id") String id , @RequestBody Section section){
        String objectId= sectionICommand.update(section,id);
        return ResponseEntity.ok()
                .body(sectionIQuerry.getById(objectId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable("id") String id){
        return ResponseEntity.ok()
                .body(sectionIQuerry.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSection(@PathVariable("id") String id){
        sectionICommand.delete(id);
        return ResponseEntity.ok().build();
    }
}
