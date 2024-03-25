package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Secretary;
import ru.sakaev.backend.repositories.SecretaryRepository;
import ru.sakaev.backend.service.SecretaryService;

import java.util.List;

@Service
public class SecretaryServiceImpl implements SecretaryService {

    private final SecretaryRepository secretaryRepository;

    @Autowired
    public SecretaryServiceImpl(SecretaryRepository secretaryRepository) {
        this.secretaryRepository = secretaryRepository;
    }

    @Override
    public Secretary getSecretaryById(Long id) {
        return secretaryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }

    // Другие методы, если нужно
}