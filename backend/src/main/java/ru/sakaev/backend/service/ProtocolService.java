package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Protocol;

import java.util.List;

public interface ProtocolService {
    Protocol getProtocolById(Long id);

    List<Protocol> getAllProtocols();

    // Другие методы, если нужно
}