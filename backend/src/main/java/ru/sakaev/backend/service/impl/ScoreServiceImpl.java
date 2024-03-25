package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Score;
import ru.sakaev.backend.repositories.ScoreRepository;
import ru.sakaev.backend.service.ScoreService;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Score getScoreById(Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public void save(Score score) {
        scoreRepository.save(score);
    }
}