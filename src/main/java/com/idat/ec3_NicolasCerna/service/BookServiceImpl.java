package com.idat.ec3_NicolasCerna.service;

import com.idat.ec3_NicolasCerna.model.Author;
import com.idat.ec3_NicolasCerna.model.Book;
import com.idat.ec3_NicolasCerna.model.Publisher;
import com.idat.ec3_NicolasCerna.repository.AuthorRepository;
import com.idat.ec3_NicolasCerna.repository.BookRepository;
import com.idat.ec3_NicolasCerna.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public Book save(Book book) {
        // Buscar autor y editorial en la base de datos antes de asignarlos
        Author author = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new RuntimeException("El autor no existe"));

        Publisher publisher = publisherRepository.findById(book.getPublisher().getId())
                .orElseThrow(() -> new RuntimeException("La editorial no existe"));

        // Asignar objetos completos
        book.setAuthor(author);
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }
}