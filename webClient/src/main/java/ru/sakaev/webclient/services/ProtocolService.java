package ru.sakaev.webclient.services;

import ru.sakaev.webclient.entity.Protocol;

import java.util.List;

public interface ProtocolService {
    List<Protocol> getAllProtocols();
    Protocol getProtocolById(Long id);
    void createProtocol(Protocol protocol);
    void updateProtocol(Long id, Protocol protocol);
    void deleteProtocol(Long id);
}
