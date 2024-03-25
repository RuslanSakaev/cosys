package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Competition;

import java.util.List;

public interface CompetitionService {
    Competition createCompetition(Competition competition);
    Competition getCompetitionById(Long id);
    List<Competition> getAllCompetitions();
    Competition updateCompetition(Long id, Competition competition);
    void deleteCompetition(Long id);
}
