package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Score;
import ru.sakaev.webclient.services.ScoreService;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final WebClient webClient;

    public ScoreServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Score getScoreById(Long id) {
        return webClient.get()
                .uri("/scores/{id}", id)
                .retrieve()
                .bodyToMono(Score.class)
                .block();
    }

    @Override
    public void createScore(Score score) {

    }

    @Override
    public void updateScore(Long id, Score score) {

    }

    @Override
    public void deleteScore(Long id) {

    }

    @Override
    public List<Score> getAllScores() {
        return webClient.get()
                .uri("/scores")
                .retrieve()
                .bodyToFlux(Score.class)
                .collectList()
                .block();
    }

    // Реализация других методов
}