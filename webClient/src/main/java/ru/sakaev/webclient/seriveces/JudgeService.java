package ru.sakaev.webclient.seriveces;

import ru.sakaev.webclient.entity.Judge;

import java.util.List;

public interface JudgeService {
    List<Judge> getAllJudges();
    Judge getJudgeById(Long id);
    void createJudge(Judge judge);
    void updateJudge(Long id, Judge judge);
    void deleteJudge(Long id);
}
