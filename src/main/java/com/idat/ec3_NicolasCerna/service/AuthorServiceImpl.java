package com.idat.ec3_NicolasCerna.service;

import com.idat.ec3_NicolasCerna.model.Author;
import com.idat.ec3_NicolasCerna.repository.AuthorRepository;
import com.idat.ec3_NicolasCerna.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository repository;

    @Override
    public List<Author> listAll() {
        return repository.findAll();
    }

    @Override
    public Author findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado con id: " + id));
    }

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}