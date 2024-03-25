package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Judge;
import ru.sakaev.backend.repositories.JudgeRepository;
import ru.sakaev.backend.service.JudgeService;

import java.util.List;
import java.util.Optional;

@Service
public class JudgeServiceImpl implements JudgeService {

    private final JudgeRepository judgeRepository;

    @Autowired
    public JudgeServiceImpl(JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }

    @Override
    public Judge createJudge(Judge judge) {
        // Валидация данных перед сохранением
        if (judge.getFirstName() == null || judge.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("Judge first name cannot be empty");
        }
        // Дополнительная валидация

        // Сохранение сущности в базе данных
        return judgeRepository.save(judge);
    }

    @Override
    public List<Judge> getAllJudges() {
        return judgeRepository.findAll();
    }

    @Override
    public Judge updateJudge(Long id, Judge judge) {
        // Проверяем существование судьи с указанным id
        Judge existingJudge = judgeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Judge with id " + id + " not found"));

        // Обновляем данные судьи
        existingJudge.setFirstName(judge.getFirstName());
        existingJudge.setLastName(judge.getLastName());
        existingJudge.setSpecialization(judge.getSpecialization());

        // Сохраняем обновленную сущность в базе данных
        return judgeRepository.save(existingJudge);
    }

    @Override
    public void deleteJudge(Long id) {
        judgeRepository.deleteById(id);
    }

    @Override
    public Optional<Judge> getJudgeById(Long id) {
        return judgeRepository.findById(id);
    }

    @Override
    public void deleteJudgeById(Long id) {
        judgeRepository.deleteById(id);
    }
}