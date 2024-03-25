package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Score;

import java.util.List;
import java.util.Optional;

public interface ScoreService {
    Score save(Score score);
    Score createScore(Score score);
    Optional<Score> getScoreById(Long id);
    List<Score> getAllScores();
    Score updateScore(Long id, Score score);
    void deleteScore(Long id);

    void deleteScoreById(Long id);

}
