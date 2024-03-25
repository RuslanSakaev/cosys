package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Competition;
import ru.sakaev.webclient.services.CompetitionService;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final WebClient webClient; // WebClient для взаимодействия с сервером

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

    @Override
    public void createCompetition(Competition competition) {
        // Логика создания соревнования
    }

    @Override
    public void updateCompetition(Long id, Competition competition) {

    }

    @Override
    public void deleteCompetition(Long id) {

    }

    // Другие методы интерфейса CompetitionService
}
