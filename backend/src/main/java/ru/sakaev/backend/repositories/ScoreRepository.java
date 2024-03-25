package ru.sakaev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.backend.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    // Дополнительные методы для работы с оценками, если нужно
}