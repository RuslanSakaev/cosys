package ru.sakaev.webclient.seriveces.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Judge;
import ru.sakaev.webclient.seriveces.JudgeService;

import java.util.List;

@Service
public abstract class JudgeServiceImpl implements JudgeService {

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