package ru.sakaev.webclient.services;

import ru.sakaev.webclient.entity.Score;

import java.util.List;
import java.util.Optional;

public interface ScoreService {

    List<Score> getAllScores();

    Optional<Score> getScoreById(Long id);

    Score createScore(Score score);

    void updateScore(Long id, Score score);

    void deleteScore(Long id);
}
