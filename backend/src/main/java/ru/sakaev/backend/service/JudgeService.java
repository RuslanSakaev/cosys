package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Judge;

import java.util.List;

public interface JudgeService {
    Judge getJudgeById(Long id);

    List<Judge> getAllJudges();

    // Другие методы, если нужно
}