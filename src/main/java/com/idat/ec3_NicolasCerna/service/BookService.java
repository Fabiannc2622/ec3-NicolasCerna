package com.idat.ec3_NicolasCerna.service;

import com.idat.ec3_NicolasCerna.model.Book;
import java.util.List;

public interface BookService {
    List<Book> listAll();
    Book findById(Integer id);
    Book save(Book book);
    Book update(Integer id, Book bookDetails);
    void delete(Integer id);
}