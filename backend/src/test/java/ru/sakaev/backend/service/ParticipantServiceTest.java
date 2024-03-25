package ru.sakaev.backend.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sakaev.backend.model.Participant;
import ru.sakaev.backend.repositories.ParticipantRepository;
import ru.sakaev.backend.service.impl.ParticipantServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ParticipantServiceTest {

    @Mock
    private ParticipantRepository participantRepository;

    @InjectMocks
    private ParticipantServiceImpl participantService;

    @Test
    void testGetAllParticipants() {
        // Создаем список моков участников
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant());
        participants.add(new Participant());

        // Настройка имитации поведения participantRepository.findAll()
        when(participantRepository.findAll()).thenReturn(participants);

        // Вызов тестируемого метода
        List<Participant> foundParticipants = participantService.getAllParticipants();

        // Проверка результата
        assertEquals(2, foundParticipants.size());
    }

    @Test
    void testCreateParticipant() {
        // Создаем мок участника
        Participant participant = new Participant();
        participant.setFirstName("John");

        // Настройка имитации поведения participantRepository.save()
        when(participantRepository.save(any(Participant.class))).thenReturn(participant);

        // Вызов тестируемого метода
        Participant createdParticipant = participantService.createParticipant(participant);

        // Проверка результата
        assertNotNull(createdParticipant);
        assertEquals("John", createdParticipant.getFirstName());
    }

}
