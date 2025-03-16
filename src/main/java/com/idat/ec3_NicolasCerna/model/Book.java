package com.idat.ec3_NicolasCerna.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "El título no puede estar vacío")
    private String title;

    @NotNull(message = "El precio no puede ser nulo")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    @NotNull(message = "La editorial no puede ser nula")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull(message = "El autor no puede ser nulo")
    private Author author;
}