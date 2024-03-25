package ru.sakaev.webclient.seriveces;

import ru.sakaev.webclient.entity.Participant;

import java.util.List;

public interface ParticipantService {
    List<Participant> getAllParticipants();
    Participant getParticipantById(Long id);
    void createParticipant(Participant participant);
    void updateParticipant(Long id, Participant participant);
    void deleteParticipant(Long id);
}
