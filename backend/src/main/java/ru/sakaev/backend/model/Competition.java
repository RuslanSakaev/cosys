package ru.sakaev.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    // Геттеры и сеттеры
}