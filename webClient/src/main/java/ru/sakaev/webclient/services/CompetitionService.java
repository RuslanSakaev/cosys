package ru.sakaev.webclient.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Competition;

public interface CompetitionService {

    Mono<Competition> getCompetitionById(Long id);

    Flux<Competition> getAllCompetitions();

    Mono<Competition> createCompetition(Competition competition);

    Mono<Void> updateCompetition(Long id, Competition competition);

    Mono<Void> deleteCompetition(Long id);
}
