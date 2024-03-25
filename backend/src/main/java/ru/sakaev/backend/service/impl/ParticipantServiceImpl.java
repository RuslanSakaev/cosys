package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Participant;
import ru.sakaev.backend.repositories.ParticipantRepository;
import ru.sakaev.backend.service.ParticipantService;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public Participant getParticipantById(Long id) {
        return participantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    // Другие методы, если нужно
}