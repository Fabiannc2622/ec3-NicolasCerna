package com.idat.ec3_NicolasCerna.controller;

import com.idat.ec3_NicolasCerna.model.Author;
import com.idat.ec3_NicolasCerna.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping
    public List<Author> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author) {
        return ResponseEntity.ok(service.save(author));
    }

    /*
    {
      "name": "J.K. Rowling"
    }
    */

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable Integer id, @RequestBody Author author) {
        author.setId(id);
        return ResponseEntity.ok(service.save(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}