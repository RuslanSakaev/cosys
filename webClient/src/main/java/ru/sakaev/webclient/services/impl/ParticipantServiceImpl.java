package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Participant;
import ru.sakaev.webclient.services.ParticipantService;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final WebClient webClient;

    public ParticipantServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Participant getParticipantById(Long id) {
        return webClient.get()
                .uri("/participants/{id}", id)
                .retrieve()
                .bodyToMono(Participant.class)
                .block();
    }

    @Override
    public void createParticipant(Participant participant) {

    }

    @Override
    public void updateParticipant(Long id, Participant participant) {

    }

    @Override
    public void deleteParticipant(Long id) {

    }

    @Override
    public List<Participant> getAllParticipants() {
        return webClient.get()
                .uri("/participants")
                .retrieve()
                .bodyToFlux(Participant.class)
                .collectList()
                .block();
    }

    // Реализация других методов
}