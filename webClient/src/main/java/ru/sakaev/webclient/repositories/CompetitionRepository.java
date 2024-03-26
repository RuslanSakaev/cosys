package ru.sakaev.webclient.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.sakaev.webclient.entity.Competition;

@Repository
public interface CompetitionRepository extends ReactiveCrudRepository<Competition, String> {
    // методы репозитория
}
