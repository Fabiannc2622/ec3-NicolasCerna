package com.idat.ec3_NicolasCerna.service;

import com.idat.ec3_NicolasCerna.model.Publisher;
import java.util.List;

public interface PublisherService {
    List<Publisher> listAll();
    Publisher findById(Integer id);
    Publisher save(Publisher publisher);
}