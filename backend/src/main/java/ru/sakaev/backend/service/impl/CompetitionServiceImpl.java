package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Competition;
import ru.sakaev.backend.repositories.CompetitionRepository;
import ru.sakaev.backend.service.CompetitionService;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private static final String COMPETITION_NOT_FOUND_MESSAGE = "Competition not found with id: ";

    @Autowired
    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public Competition createCompetition(Competition competition) {
        // Валидация данных перед сохранением
        if (competition.getName() == null || competition.getName().isEmpty()) {
            throw new IllegalArgumentException("Competition name cannot be empty");
        }
        // Дополнительная валидация (по необходимости)

        // Сохранение сущности в базе данных
        return competitionRepository.save(competition);
    }

    @Override
    public Competition getCompetitionById(Long id) {
        // Поиск соревнования по ID
        Optional<Competition> competitionOptional = competitionRepository.findById(id);
        if (competitionOptional.isPresent()) {
            return competitionOptional.get();
        } else {
            throw new IllegalArgumentException(COMPETITION_NOT_FOUND_MESSAGE + id);
        }
    }

    @Override
    public List<Competition> getAllCompetitions() {
        // Получение всех соревнований из базы данных
        return competitionRepository.findAll();
    }

    @Override
    public Competition updateCompetition(Long id, Competition competition) {
        // Проверка существования соревнования с указанным ID
        if (!competitionRepository.existsById(id)) {
            throw new IllegalArgumentException(COMPETITION_NOT_FOUND_MESSAGE + id);
        }
        // Обновление данных о соревновании и сохранение изменений
        competition.setId(id);
        return competitionRepository.save(competition);
    }

    @Override
    public void deleteCompetition(Long id) {
        // Проверка существования соревнования с указанным ID
        if (!competitionRepository.existsById(id)) {
            throw new IllegalArgumentException(COMPETITION_NOT_FOUND_MESSAGE + id);
        }
        // Удаление соревнования из базы данных
        competitionRepository.deleteById(id);
    }
}
