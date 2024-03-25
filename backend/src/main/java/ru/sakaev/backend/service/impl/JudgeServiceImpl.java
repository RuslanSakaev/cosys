package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Judge;
import ru.sakaev.backend.repositories.JudgeRepository;
import ru.sakaev.backend.service.JudgeService;

import java.util.List;

@Service
public class JudgeServiceImpl implements JudgeService {

    private final JudgeRepository judgeRepository;

    @Autowired
    public JudgeServiceImpl(JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }

    @Override
    public Judge getJudgeById(Long id) {
        return judgeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Judge> getAllJudges() {
        return judgeRepository.findAll();
    }

    // Другие методы, если нужно
}