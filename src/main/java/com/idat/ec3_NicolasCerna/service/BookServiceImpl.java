package com.idat.ec3_NicolasCerna.service;

import com.idat.ec3_NicolasCerna.model.Book;
import com.idat.ec3_NicolasCerna.repository.BookRepository;
import com.idat.ec3_NicolasCerna.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Integer id, Book bookDetails) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setPrice(bookDetails.getPrice());
            if (bookDetails.getAuthor() != null && bookDetails.getAuthor().getId() != null) {
                existingBook.setAuthor(bookDetails.getAuthor());
            }
            if (bookDetails.getPublisher() != null && bookDetails.getPublisher().getId() != null) {
                existingBook.setPublisher(bookDetails.getPublisher());
            }
            return bookRepository.save(existingBook);
        }).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}