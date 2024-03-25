package ru.sakaev.backend.service;

import ru.sakaev.backend.model.Secretary;

import java.util.List;
import java.util.Optional;

public interface SecretaryService {
    Secretary createSecretary(Secretary secretary);
    Optional<Secretary> getSecretaryById(Long id);
    List<Secretary> getAllSecretaries();
    Secretary updateSecretary(Long id, Secretary secretary);
    void deleteSecretary(Long id);

    void deleteSecretaryById(Long id);
}
