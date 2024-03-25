package ru.sakaev.backend.service;

import java.util.List;

public class GymnasticsScoring {

    // Метод для подсчета итоговой оценки по технике
    public static double calculateTechnicalScore(List<Double> executionScores, List<Double> deductions) {
        double totalExecutionScore = calculateTotalScore(executionScores);
        double totalDeductions = calculateTotalDeductions(deductions);
        double finalExecutionScore = totalExecutionScore - totalDeductions;
        return finalExecutionScore;
    }

    // Метод для подсчета общей суммы оценок
    private static double calculateTotalScore(List<Double> scores) {
        double sum = 0;
        for (Double score : scores) {
            sum += score;
        }
        return sum;
    }

    // Метод для подсчета общей суммы сбавок
    private static double calculateTotalDeductions(List<Double> deductions) {
        double sum = 0;
        for (Double deduction : deductions) {
            sum += deduction;
        }
        return sum;
    }

    // Метод для определения итоговой оценки
    public static double calculateFinalScore(double technicalScore, double artisticScore, double riskScore) {
        double totalScore = (technicalScore + artisticScore + riskScore) / 3.0;
        return totalScore;
    }

    public static void main(String[] args) {
        // Пример использования методов для подсчета оценок
        List<Double> executionScores = List.of(9.5, 9.7, 9.8); // Оценки за исполнение
        List<Double> deductions = List.of(0.1, 0.2, 0.3); // Сбавки за ошибки
        double technicalScore = calculateTechnicalScore(executionScores, deductions);

        double artisticScore = 9.0; // Пример оценки за артистизм
        double riskScore = 8.5; // Пример оценки за элементы риска

        double finalScore = calculateFinalScore(technicalScore, artisticScore, riskScore);
        System.out.println("Итоговая оценка: " + finalScore);
    }
}
