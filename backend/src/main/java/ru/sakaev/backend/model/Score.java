package ru.sakaev.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Double value;

    @Column(name = "final_score")
    private double finalScore;

    // Геттер и сеттер для участника оценки
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

}