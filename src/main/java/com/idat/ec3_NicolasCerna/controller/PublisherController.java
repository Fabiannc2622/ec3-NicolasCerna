package com.idat.ec3_NicolasCerna.controller;

import com.idat.ec3_NicolasCerna.model.Publisher;
import com.idat.ec3_NicolasCerna.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherService service;

    // Listar todas las editoriales
    @GetMapping
    public List<Publisher> listAll() {
        return service.listAll();
    }

    // Buscar una editorial por ID
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Guardar una nueva editorial
    @PostMapping
    public ResponseEntity<Publisher> save(@RequestBody Publisher publisher) {
        return ResponseEntity.ok(service.save(publisher));
    }

    // Editar una editorial
    @PutMapping("/{id}")
    public ResponseEntity<Publisher> update(@PathVariable Integer id, @RequestBody Publisher publisher) {
        publisher.setId(id);
        return ResponseEntity.ok(service.save(publisher));
    }

    // Eliminar una editorial
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}