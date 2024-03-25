package ru.sakaev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.backend.model.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    // Дополнительные методы для работы с соревнованиями, если нужно
}