package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Participant;
import ru.sakaev.webclient.services.ParticipantService;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private static final String PARTICIPANTS_ENDPOINT = "/participants";
    private static final String PARTICIPANT_BY_ID_ENDPOINT = PARTICIPANTS_ENDPOINT + "/{id}";

    private final WebClient webClient;

    public ParticipantServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Optional<Participant> getParticipantById(Long id) {
        return webClient.get()
                .uri(PARTICIPANT_BY_ID_ENDPOINT, id)
                .retrieve()
                .bodyToMono(Participant.class).blockOptional();
    }

    @Override
    public Mono<Void> createParticipant(Participant participant) {
        return webClient.post()
                .uri(PARTICIPANTS_ENDPOINT)
                .bodyValue(participant)
                .retrieve()
                .bodyToMono(Void.class)
                .then();
    }

    @Override
    public Mono<Void> updateParticipant(Long id, Participant participant) {
        return webClient.put()
                .uri(PARTICIPANT_BY_ID_ENDPOINT, id)
                .bodyValue(participant)
                .retrieve()
                .bodyToMono(Void.class)
                .then();
    }

    @Override
    public Mono<Void> deleteParticipant(Long id) {
        return webClient.delete()
                .uri(PARTICIPANT_BY_ID_ENDPOINT, id)
                .retrieve()
                .bodyToMono(Void.class)
                .then();
    }

    @Override
    public List<Participant> getAllParticipants() {
        return webClient.get()
                .uri(PARTICIPANTS_ENDPOINT)
                .retrieve()
                .bodyToFlux(Participant.class)
                .collectList()
                .block();
    }
}
