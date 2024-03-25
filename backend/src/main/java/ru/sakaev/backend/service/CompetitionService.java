package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Competition;

import java.util.List;

public interface CompetitionService {
    Competition getCompetitionById(Long id);

    List<Competition> getAllCompetitions();

    // Другие методы, если нужно
}