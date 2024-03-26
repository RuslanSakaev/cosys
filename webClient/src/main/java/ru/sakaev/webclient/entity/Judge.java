package ru.sakaev.webclient.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Component
public class Judge {

    private final WebClient webClient;

    public Judge(@Value("${judge.base-url}") String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Competition getCompetitionById(Long id) {
        try {
            return this.webClient.get()
                    .uri("/api/competitions/{id}", id)
                    .retrieve()
                    .bodyToMono(Competition.class)
                    .block();
        } catch (Exception e) {
            // Обработка ошибки
            return null;
        }
    }

    public List<Competition> getAllCompetitions() {
        try {
            return this.webClient.get()
                    .uri("/api/competitions")
                    .retrieve()
                    .bodyToFlux(Competition.class)
                    .collectList()
                    .block();
        } catch (Exception e) {
            // Обработка ошибки
            return Collections.emptyList();
        }
    }

    public Submission submitSolution(Long competitionId, String solution) {
        try {
            return this.webClient.post()
                    .uri("/api/competitions/{id}/submit", competitionId)
                    .bodyValue(solution)
                    .retrieve()
                    .bodyToMono(Submission.class)
                    .block();
        } catch (Exception e) {
            // Обработка ошибки
            return null;
        }
    }


    public void setId(Long id) {
        // This method is empty because the Judge entity does not have an id field to set.
        // If needed in the future, appropriate logic can be added here.
        throw new UnsupportedOperationException("setId() method is not supported for Judge entity");
    }
}

