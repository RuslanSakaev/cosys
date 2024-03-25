package ru.sakaev.backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import ru.sakaev.backend.model.Competition;
import ru.sakaev.backend.repositories.CompetitionRepository;
import ru.sakaev.backend.service.impl.CompetitionServiceImpl;

@SpringBootTest
class CompetitionServiceTest {

    @Mock
    private CompetitionRepository competitionRepository;

    @InjectMocks
    private CompetitionServiceImpl competitionService;

    @Test
    void testGetAllCompetitions() {
        // Создаем список моков соревнований
        List<Competition> competitions = new ArrayList<>();
        competitions.add(new Competition());
        competitions.add(new Competition());

        // Настройка имитации поведения competitionRepository.findAll()
        when(competitionRepository.findAll()).thenReturn(competitions);

        // Вызов тестируемого метода
        List<Competition> foundCompetitions = competitionService.getAllCompetitions();

        // Проверка результата
        assertEquals(2, foundCompetitions.size());
    }

    @Test
    void testGetCompetitionById() {
        // Создаем мок соревнования
        Competition competition = new Competition();
        competition.setId(1L);

        // Настройка имитации поведения competitionRepository.findById()
        when(competitionRepository.findById(1L)).thenReturn(Optional.of(competition));

        // Вызов тестируемого метода
        Competition foundCompetition = competitionService.getCompetitionById(1L);

        // Проверка результата
        assertNotNull(foundCompetition);
        assertEquals(1L, foundCompetition.getId());
    }

}
