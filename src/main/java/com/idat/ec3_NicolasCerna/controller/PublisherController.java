package com.idat.ec3_NicolasCerna.controller;

import com.idat.ec3_NicolasCerna.model.Publisher;
import com.idat.ec3_NicolasCerna.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")  // Agregamos "api" para seguir la convención REST
public class PublisherController {

    @Autowired
    private PublisherService service;

    @GetMapping
    public ResponseEntity<List<Publisher>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable Integer id) {
        Publisher publisher = service.findById(id);
        return publisher != null ? ResponseEntity.ok(publisher) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Publisher> save(@RequestBody Publisher publisher) {
        return ResponseEntity.ok(service.save(publisher));
    }
}