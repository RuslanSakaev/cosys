package ru.sakaev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.backend.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    // Дополнительные методы для работы с участниками, если нужно
}