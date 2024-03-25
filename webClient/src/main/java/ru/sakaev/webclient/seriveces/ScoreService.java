package ru.sakaev.webclient.seriveces;

import ru.sakaev.webclient.entity.Score;

import java.util.List;

public interface ScoreService {
    List<Score> getAllScores();
    Score getScoreById(Long id);
    void createScore(Score score);
    void updateScore(Long id, Score score);
    void deleteScore(Long id);
}
