package ru.sakaev.webclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.webclient.entity.Protocol;
import ru.sakaev.webclient.repositories.ProtocolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProtocolService {

    private final ProtocolRepository protocolRepository;

    @Autowired
    public ProtocolService(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }

    public List<Protocol> getAllProtocols() {
        return protocolRepository.findAll();
    }

    public Optional<Protocol> getProtocolById(Long id) {
        return protocolRepository.findById(id);
    }

    public Protocol createProtocol(Protocol protocol) {
        return protocolRepository.save(protocol);
    }

    public void updateProtocol(Long id, Protocol protocol) {
        protocol.setId(id);
        protocolRepository.save(protocol);
    }

    public void deleteProtocol(Long id) {
        protocolRepository.deleteById(id);
    }
}
