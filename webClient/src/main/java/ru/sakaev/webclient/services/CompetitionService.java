package ru.sakaev.webclient.services;

import ru.sakaev.webclient.entity.Competition;

import java.util.List;

public interface CompetitionService {
    List<Competition> getAllCompetitions();
    Competition getCompetitionById(Long id);
    void createCompetition(Competition competition);
    void updateCompetition(Long id, Competition competition);
    void deleteCompetition(Long id);
}
