package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Judge;

import java.util.List;
import java.util.Optional;

public interface JudgeService {
    Judge createJudge(Judge judge);
    Optional<Judge> getJudgeById(Long id);
    List<Judge> getAllJudges();
    Judge updateJudge(Long id, Judge judge);
    void deleteJudge(Long id);

    void deleteJudgeById(Long id);
}
