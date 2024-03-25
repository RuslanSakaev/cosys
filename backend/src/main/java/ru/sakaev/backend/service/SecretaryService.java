package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Secretary;

import java.util.List;

public interface SecretaryService {
    Secretary getSecretaryById(Long id);

    List<Secretary> getAllSecretaries();

    // Другие методы, если нужно
}