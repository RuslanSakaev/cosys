package ru.sakaev.webclient.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Competition;
import ru.sakaev.webclient.repositories.CompetitionRepository;
import ru.sakaev.webclient.services.CompetitionService;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String COMPETITIONS_ENDPOINT = "/api/competitions";
    private static final String COMPETITION_BY_ID_ENDPOINT = COMPETITIONS_ENDPOINT + "/{id}";

    private final WebClient webClient;

    @Autowired
    public CompetitionServiceImpl(CompetitionRepository competitionRepository, WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    @Override
    public Mono<Competition> getCompetitionById(Long id) {
        return webClient.get()
                .uri(COMPETITION_BY_ID_ENDPOINT, id)
                .retrieve()
                .bodyToMono(Competition.class);
    }

    @Override
    public Flux<Competition> getAllCompetitions() {
        return webClient.get()
                .uri(COMPETITIONS_ENDPOINT)
                .retrieve()
                .bodyToFlux(Competition.class);
    }

    @Override
    public Mono<Competition> createCompetition(Competition competition) {
        return webClient.post()
                .uri(COMPETITIONS_ENDPOINT)
                .bodyValue(competition)
                .retrieve()
                .bodyToMono(Competition.class);
    }

    @Override
    public Mono<Void> updateCompetition(Long id, Competition competition) {
        return webClient.put()
                .uri(COMPETITION_BY_ID_ENDPOINT, id)
                .bodyValue(competition)
                .retrieve()
                .toBodilessEntity()
                .then();
    }

    @Override
    public Mono<Void> deleteCompetition(Long id) {
        return webClient.delete()
                .uri(COMPETITION_BY_ID_ENDPOINT, id)
                .retrieve()
                .toBodilessEntity()
                .then();
    }
}
