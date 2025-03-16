package com.idat.ec3_NicolasCerna.service;

import com.idat.ec3_NicolasCerna.model.Book;
import com.idat.ec3_NicolasCerna.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> listAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
