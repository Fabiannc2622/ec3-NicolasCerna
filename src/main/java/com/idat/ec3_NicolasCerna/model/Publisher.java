package com.idat.ec3_NicolasCerna.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hibernate autogenera el ID
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String country;  // Permite valores nulos
}