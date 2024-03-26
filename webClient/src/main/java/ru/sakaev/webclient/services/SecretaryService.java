package ru.sakaev.webclient.services;

import ru.sakaev.webclient.entity.Secretary;

import java.util.List;

public interface SecretaryService {

    List<Secretary> getAllSecretaries();

    Secretary getSecretaryById(Long id);

    Secretary createSecretary(Secretary secretary);

    void updateSecretary(Long id, Secretary secretary);

    void deleteSecretary(Long id);
}
