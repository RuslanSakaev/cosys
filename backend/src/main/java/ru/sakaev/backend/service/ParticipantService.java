package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Participant;

import java.util.List;

public interface ParticipantService {
    Participant getParticipantById(Long id);

    List<Participant> getAllParticipants();

    // Другие методы, если нужно
}