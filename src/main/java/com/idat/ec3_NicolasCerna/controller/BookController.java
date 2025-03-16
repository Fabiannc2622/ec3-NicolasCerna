package com.idat.ec3_NicolasCerna.controller;

import com.idat.ec3_NicolasCerna.model.Book;
import com.idat.ec3_NicolasCerna.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Obtener todos los libros
    @GetMapping
    public List<Book> listAll() {
        return bookService.listAll();
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    // Crear un nuevo libro
    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }
}