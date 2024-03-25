package ru.sakaev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.backend.model.Secretary;

public interface SecretaryRepository extends JpaRepository<Secretary, Long> {
    // Дополнительные методы для работы с секретарями, если нужно
}