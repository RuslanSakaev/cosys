package ru.sakaev.backend.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sakaev.backend.model.Judge;
import ru.sakaev.backend.repositories.JudgeRepository;
import ru.sakaev.backend.service.impl.JudgeServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class JudgeServiceTest {

    @Mock
    private JudgeRepository judgeRepository;

    @InjectMocks
    private JudgeServiceImpl judgeService;

    @Test
    void testGetAllJudges() {
        // Создаем список моков судей
        List<Judge> judges = new ArrayList<>();
        judges.add(new Judge());
        judges.add(new Judge());

        // Настройка имитации поведения judgeRepository.findAll()
        when(judgeRepository.findAll()).thenReturn(judges);

        // Вызов тестируемого метода
        List<Judge> foundJudges = judgeService.getAllJudges();

        // Проверка результата
        assertEquals(2, foundJudges.size());
    }

    @Test
    void testCreateJudge() {
        // Создаем мок судьи
        Judge judge = new Judge();
        judge.setFirstName("John");

        // Настройка имитации поведения judgeRepository.save()
        when(judgeRepository.save(any(Judge.class))).thenReturn(judge);

        // Вызов тестируемого метода
        Judge createdJudge = judgeService.createJudge(judge);

        // Проверка результата
        assertNotNull(createdJudge);
        assertEquals("John", createdJudge.getFirstName());
    }

}
