package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Judge;
import ru.sakaev.webclient.services.JudgeService;

import java.util.List;

@Service
public class JudgeServiceImpl implements JudgeService {

    private final WebClient webClient;

    public JudgeServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Judge getJudgeById(Long id) {
        return webClient.get()
                .uri("/judges/{id}", id)
                .retrieve()
                .bodyToMono(Judge.class)
                .block();
    }

    @Override
    public void createJudge(Judge judge) {

    }

    @Override
    public void updateJudge(Long id, Judge judge) {

    }

    @Override
    public void deleteJudge(Long id) {

    }

    @Override
    public List<Judge> getAllJudges() {
        return webClient.get()
                .uri("/judges")
                .retrieve()
                .bodyToFlux(Judge.class)
                .collectList()
                .block();
    }

    // Реализация других методов
}