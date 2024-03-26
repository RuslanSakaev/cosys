package ru.sakaev.webclient.services;

import ru.sakaev.webclient.entity.Judge;

import java.util.List;
import java.util.Optional;

public interface JudgeService {

    List<Judge> getAllJudges();

    Optional<Judge> getJudgeById(Long id);

    Judge createJudge(Judge judge);

    Judge updateJudge(Long id, Judge judge);

    void deleteJudge(Long id);
}
