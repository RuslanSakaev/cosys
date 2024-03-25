package ru.sakaev.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.backend.model.Judge;

public interface JudgeRepository extends JpaRepository<Judge, Long> {
    // Дополнительные методы для работы с судьями, если нужно
}