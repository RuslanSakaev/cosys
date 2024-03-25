package ru.sakaev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.backend.model.Protocol;

public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
    // Дополнительные методы для работы с протоколами, если нужно
}