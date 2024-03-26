package ru.sakaev.webclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.webclient.entity.Judge;
import ru.sakaev.webclient.repositories.JudgeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JudgeService {

    private final JudgeRepository judgeRepository;

    @Autowired
    public JudgeService(JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }

    public List<Judge> getAllJudges() {
        return judgeRepository.findAll();
    }

    public Optional<Judge> getJudgeById(Long id) {
        return judgeRepository.findById(id);
    }

    public Judge createJudge(Judge judge) {
        return judgeRepository.save(judge);
    }

    public Judge updateJudge(Long id, Judge judge) {
        return judgeRepository.findById(id)
                .map(existingJudge -> {
                    judge.setId(id);
                    return judgeRepository.save(judge);
                })
                .orElseThrow(() -> new NoSuchElementException("Judge with id " + id + " not found"));
    }


    public void deleteJudge(Long id) {
        judgeRepository.deleteById(id);
    }
}
