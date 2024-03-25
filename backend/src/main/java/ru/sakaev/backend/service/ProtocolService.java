package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Protocol;

import java.util.List;
import java.util.Optional;

public interface ProtocolService {
    Protocol createProtocol(Protocol protocol);
    Optional<Protocol> getProtocolById(Long id);
    List<Protocol> getAllProtocols();
    Protocol updateProtocol(Long id, Protocol protocol);
    void deleteProtocol(Long id);

    void deleteProtocolById(Long id);
}
