package ru.sakaev.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "secretaries")
public class Secretary {

    // Геттер и сеттер для id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Геттер и сеттер для имени
    @Column(name = "name")
    private String name;

}
