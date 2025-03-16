package com.idat.ec3_NicolasCerna.service;

import com.idat.ec3_NicolasCerna.model.Author;
import java.util.List;

public interface AuthorService {
    List<Author> listAll();
    Author findById(Integer id);
    Author save(Author author);
    void delete(Integer id);
}