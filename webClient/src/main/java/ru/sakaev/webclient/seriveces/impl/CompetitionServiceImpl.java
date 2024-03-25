package ru.sakaev.webclient.seriveces.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Competition;
import ru.sakaev.webclient.seriveces.CompetitionService;
import java.util.List;

@Service
public abstract class CompetitionServiceImpl implements CompetitionService {

    private final WebClient webClient; // Здесь должен быть настроенный WebClient для взаимодействия с сервером

    public CompetitionServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Competition getCompetitionById(Long id) {
        return webClient.get()
                .uri("/competitions/{id}", id)
                .retrieve()
                .bodyToMono(Competition.class)
                .block();
    }

    @Override
    public List<Competition> getAllCompetitions() {
        return webClient.get()
                .uri("/competitions")
                .retrieve()
                .bodyToFlux(Competition.class)
                .collectList()
                .block();
    }

    // Реализация других методов
}
