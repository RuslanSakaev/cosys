package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Score;
import ru.sakaev.backend.repositories.ScoreRepository;
import ru.sakaev.backend.service.ScoreService;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Score save(Score score) {
        return null;
    }

    @Override
    public Score createScore(Score score) {
        // Валидация данных перед сохранением
        if (score.getParticipant() == null) {
            throw new IllegalArgumentException("Score participant cannot be null");
        }
        // Дополнительная валидация

        // Сохранение сущности в базе данных
        return scoreRepository.save(score);
    }
    @Override
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public Score updateScore(Long id, Score score) {
        // Проверка существования оценки с указанным id
        if (!scoreRepository.existsById(id)) {
            throw new IllegalArgumentException("Score with id " + id + " does not exist");
        }
        score.setId(id); // Установка id для сущности
        return scoreRepository.save(score); // Сохранение обновленной сущности
    }

    @Override
    public void deleteScore(Long id) {
        // Проверка существования оценки с указанным id
        if (!scoreRepository.existsById(id)) {
            throw new IllegalArgumentException("Score with id " + id + " does not exist");
        }
        scoreRepository.deleteById(id); // Удаление оценки из базы данных
    }

    @Override
    public Optional<Score> getScoreById(Long id) {
        return scoreRepository.findById(id); // Получение оценки по id
    }

    @Override
    public void deleteScoreById(Long id) {
        scoreRepository.deleteById(id); // Удаление оценки по id
    }
}