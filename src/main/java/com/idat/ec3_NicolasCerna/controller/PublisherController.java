package com.idat.ec3_NicolasCerna.controller;

import com.idat.ec3_NicolasCerna.model.Publisher;
import com.idat.ec3_NicolasCerna.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService service;

    @GetMapping
    public List<Publisher> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Publisher findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Publisher save(@RequestBody Publisher publisher) {
        return service.save(publisher);
    }
}