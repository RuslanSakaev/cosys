package ru.sakaev.webclient.seriveces.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Participant;
import ru.sakaev.webclient.seriveces.ParticipantService;

import java.util.List;

@Service
public abstract class ParticipantServiceImpl implements ParticipantService {

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