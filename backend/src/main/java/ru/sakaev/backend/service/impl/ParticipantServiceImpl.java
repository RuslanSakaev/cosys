package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Participant;
import ru.sakaev.backend.repositories.ParticipantRepository;
import ru.sakaev.backend.service.ParticipantService;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public Participant createParticipant(Participant participant) {
        // Валидация данных перед сохранением
        if (participant.getFirstName() == null || participant.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("Participant first name cannot be empty");
        }
        // Дополнительная валидация

        // Сохранение сущности в базе данных
        return participantRepository.save(participant);
    }

    @Override
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    @Override
    public Participant updateParticipant(Long id, Participant participant) {
        // Проверка существования участника с заданным id
        Optional<Participant> existingParticipantOptional = participantRepository.findById(id);
        if (existingParticipantOptional.isPresent()) {
            Participant existingParticipant = existingParticipantOptional.get();
            // Обновление данных участника
            existingParticipant.setFirstName(participant.getFirstName());
            existingParticipant.setLastName(participant.getLastName());
            existingParticipant.setAge(participant.getAge());
            existingParticipant.setGender(participant.getGender());
            existingParticipant.setCountry(participant.getCountry());
            // Дополнительная валидация

            // Сохранение обновленной сущности в базе данных
            return participantRepository.save(existingParticipant);
        } else {
            throw new IllegalArgumentException("Participant not found with id: " + id);
        }
    }

    @Override
    public void deleteParticipant(Long id) {
        // Удаление участника по id
        participantRepository.deleteById(id);
    }

    @Override
    public Optional<Participant> getParticipantById(Long id) {
        // Получение участника по id
        return participantRepository.findById(id);
    }

    @Override
    public void deleteParticipantById(Long id) {
        // Удаление участника по id
        participantRepository.deleteById(id);
    }
}