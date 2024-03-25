package ru.sakaev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Score;

import java.util.List;

@Service
public class GymnasticsScoringService {

    private final ScoreService scoreService;

    @Autowired
    public GymnasticsScoringService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    // Метод для подсчета итоговой оценки по технике
    public double calculateTechnicalScore(List<Double> executionScores, List<Double> deductions) {
        double totalExecutionScore = calculateTotalScore(executionScores);
        double totalDeductions = calculateTotalDeductions(deductions);
        return totalExecutionScore - totalDeductions;
    }

    // Метод для подсчета общей суммы оценок
    private double calculateTotalScore(List<Double> scores) {
        double sum = 0;
        for (Double score : scores) {
            sum += score;
        }
        return sum;
    }

    // Метод для подсчета общей суммы сбавок
    private double calculateTotalDeductions(List<Double> deductions) {
        double sum = 0;
        for (Double deduction : deductions) {
            sum += deduction;
        }
        return sum;
    }

    // Метод для определения итоговой оценки
    public double calculateFinalScore(double technicalScore, double artisticScore, double riskScore) {
        return (technicalScore + artisticScore + riskScore) / 3.0;
    }

    // Пример метода для сохранения оценки в базе данных
    public void saveScore(double finalScore) {
        Score score = new Score();
        score.setFinalScore(finalScore);
        scoreService.save(score);
    }
}