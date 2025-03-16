package com.idat.ec3_NicolasCerna.repository;

import com.idat.ec3_NicolasCerna.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}