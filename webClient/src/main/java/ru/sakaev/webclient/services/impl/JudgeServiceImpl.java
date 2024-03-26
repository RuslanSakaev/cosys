package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Judge;
import ru.sakaev.webclient.repositories.JudgeRepository;
import ru.sakaev.webclient.services.JudgeService;

import java.util.List;
import java.util.Optional;

@Service
public class JudgeServiceImpl extends JudgeService {

    private final WebClient webClient;

    public JudgeServiceImpl(WebClient webClient) {
        super((JudgeRepository) webClient);
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
