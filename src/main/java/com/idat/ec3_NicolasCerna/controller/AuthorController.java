package com.idat.ec3_NicolasCerna.controller;

import com.idat.ec3_NicolasCerna.model.Author;
import com.idat.ec3_NicolasCerna.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping
    public List<Author> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Author save(@RequestBody Author author) {
        return service.save(author);
    }
}
