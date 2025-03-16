package com.idat.ec3_NicolasCerna.controller;

import com.idat.ec3_NicolasCerna.model.Book;
import com.idat.ec3_NicolasCerna.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> listAll() {
        return bookService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book savedBook = bookService.save(book);
        return ResponseEntity.ok(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.update(id, bookDetails);

        if (updatedBook == null) {
            return ResponseEntity.status(404).body(null);  // Retorna 404 si no se encuentra
        }

        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        Book existingBook = bookService.findById(id);
        if (existingBook == null) {
            return ResponseEntity.notFound().build();
        }
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}