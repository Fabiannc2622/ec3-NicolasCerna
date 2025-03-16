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

    // Listar todos los autores
    @GetMapping
    public List<Author> listAll() {
        return service.listAll();
    }

    // Buscar un autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Guardar un nuevo autor
    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author) {
        return ResponseEntity.ok(service.save(author));
    }

    // Editar un autor
    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable Integer id, @RequestBody Author author) {
        author.setId(id);
        return ResponseEntity.ok(service.save(author));
    }

    // Eliminar un autor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}