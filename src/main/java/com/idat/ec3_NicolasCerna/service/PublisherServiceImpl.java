package com.idat.ec3_NicolasCerna.service;

import com.idat.ec3_NicolasCerna.model.Publisher;
import com.idat.ec3_NicolasCerna.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository repository;

    @Override
    public List<Publisher> listAll() {
        return repository.findAll();
    }

    @Override
    public Publisher findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return repository.save(publisher);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}