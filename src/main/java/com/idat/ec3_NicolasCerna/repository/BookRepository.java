package com.idat.ec3_NicolasCerna.repository;

import com.idat.ec3_NicolasCerna.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}