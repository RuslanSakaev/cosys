package ru.sakaev.webclient.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.sakaev.webclient.entity.Competition;

public interface CompetitionRepository extends ReactiveCrudRepository<Competition, String> {
}
