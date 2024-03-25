package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Protocol;
import ru.sakaev.backend.repositories.ProtocolRepository;
import ru.sakaev.backend.service.ProtocolService;

import java.util.List;
import java.util.Optional;

@Service
public class ProtocolServiceImpl implements ProtocolService {

    private final ProtocolRepository protocolRepository;

    @Autowired
    public ProtocolServiceImpl(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }

    @Override
    public Protocol createProtocol(Protocol protocol) {
        // Валидация данных перед сохранением
        if (protocol.getName() == null || protocol.getName().isEmpty()) {
            throw new IllegalArgumentException("Protocol name cannot be empty");
        }
        // Дополнительная валидация

        // Сохранение сущности в базе данных
        return protocolRepository.save(protocol);
    }

    @Override
    public List<Protocol> getAllProtocols() {
        return protocolRepository.findAll();
    }

    @Override
    public Protocol updateProtocol(Long id, Protocol protocol) {
        // Проверка существования протокола с указанным id
        if (!protocolRepository.existsById(id)) {
            throw new IllegalArgumentException("Protocol with id " + id + " does not exist");
        }
        protocol.setId(id); // Установка id для сущности
        return protocolRepository.save(protocol); // Сохранение обновленной сущности
    }

    @Override
    public void deleteProtocol(Long id) {
        // Проверка существования протокола с указанным id
        if (!protocolRepository.existsById(id)) {
            throw new IllegalArgumentException("Protocol with id " + id + " does not exist");
        }
        protocolRepository.deleteById(id); // Удаление протокола из базы данных
    }

    @Override
    public Optional<Protocol> getProtocolById(Long id) {
        return protocolRepository.findById(id); // Получение протокола по id
    }

    @Override
    public void deleteProtocolById(Long id) {
        protocolRepository.deleteById(id); // Удаление протокола по id
    }
}