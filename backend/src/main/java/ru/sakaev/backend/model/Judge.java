package ru.sakaev.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "judges")
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // Геттеры и сеттеры
}