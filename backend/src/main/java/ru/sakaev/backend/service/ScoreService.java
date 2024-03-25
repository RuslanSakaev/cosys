package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Score;

import java.util.List;

public interface ScoreService {
    Score getScoreById(Long id);

    List<Score> getAllScores();

    void save(Score score);

    // Другие методы, если нужно
}