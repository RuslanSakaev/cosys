package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Protocol;
import ru.sakaev.backend.repositories.ProtocolRepository;
import ru.sakaev.backend.service.ProtocolService;

import java.util.List;

@Service
public class ProtocolServiceImpl implements ProtocolService {

    private final ProtocolRepository protocolRepository;

    @Autowired
    public ProtocolServiceImpl(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }

    @Override
    public Protocol getProtocolById(Long id) {
        return protocolRepository.findById(id).orElse(null);
    }

    @Override
    public List<Protocol> getAllProtocols() {
        return protocolRepository.findAll();
    }

    // Другие методы, если нужно
}