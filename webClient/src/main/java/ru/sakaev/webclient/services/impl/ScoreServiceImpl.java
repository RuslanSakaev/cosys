package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Score;
import ru.sakaev.webclient.services.ScoreService;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final WebClient webClient;

    public ScoreServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Optional<Score> getScoreById(Long id) {
        return Optional.ofNullable(webClient.get()
                .uri("/scores/{id}", id)
                .retrieve()
                .bodyToMono(Score.class)
                .block());
    }

    @Override
    public Score createScore(Score score) {
        // Логика создания оценки
        return score;
    }

    @Override
    public void updateScore(Long id, Score score) {
        // Логика обновления оценки
    }

    @Override
    public void deleteScore(Long id) {
        // Логика удаления оценки
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
}
