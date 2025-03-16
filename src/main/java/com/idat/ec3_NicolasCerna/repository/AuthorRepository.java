package com.idat.ec3_NicolasCerna.repository;

import com.idat.ec3_NicolasCerna.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}