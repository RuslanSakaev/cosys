package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Participant;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {
    Participant createParticipant(Participant participant);
    Optional<Participant> getParticipantById(Long id);
    List<Participant> getAllParticipants();
    Participant updateParticipant(Long id, Participant participant);
    void deleteParticipant(Long id);

    void deleteParticipantById(Long id);
}
