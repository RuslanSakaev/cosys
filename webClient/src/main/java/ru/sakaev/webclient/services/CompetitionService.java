package ru.sakaev.webclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Competition;
import ru.sakaev.webclient.repositories.CompetitionRepository;

@Service
public abstract class CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Autowired
    protected CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public Mono<Competition> getCompetitionById(Long id) {
        return competitionRepository.findById(id.toString());
    }

    public Flux<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public Mono<Competition> createCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    public Mono<Competition> updateCompetition(String id, Competition competition) {
        competition.setId(id);
        return competitionRepository.save(competition);
    }

    public Mono<Void> deleteCompetition(String id) {
        return competitionRepository.deleteById(id);
    }

    public Mono<Competition> petitionById(String id) {
        return competitionRepository.findById(id); // Поиск соревнования по ID и его возврат
    }

    public abstract Mono<Void> updateCompetition(Long id, Competition competition);

    public abstract Mono<Void> deleteCompetition(Long id);
}
