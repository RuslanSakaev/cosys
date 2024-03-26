package ru.sakaev.webclient.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Judge;
import ru.sakaev.webclient.services.JudgeService;

import java.util.List;
import java.util.Optional;

@Service
public class JudgeServiceImpl implements JudgeService {

    private final WebClient webClient;

    @Autowired
    public JudgeServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Optional<Judge> getJudgeById(Long id) {
        return Optional.ofNullable(webClient.get()
                .uri("/judges/{id}", id)
                .retrieve()
                .bodyToMono(Judge.class)
                .block());
    }

    @Override
    public Judge createJudge(Judge judge) {
        // Логика создания судьи
        return judge;
    }

    @Override
    public Judge updateJudge(Long id, Judge judge) {
        // Логика обновления судьи
        return judge;
    }

    @Override
    public void deleteJudge(Long id) {
        // Логика удаления судьи
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

}
