package ru.sakaev.webclient.services;

import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Participant;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {

    List<Participant> getAllParticipants();

    Optional<Participant> getParticipantById(Long id);

    Mono<Void> createParticipant(Participant participant);

    Mono<Void> updateParticipant(Long id, Participant participant);

    Mono<Void> deleteParticipant(Long id);
}
