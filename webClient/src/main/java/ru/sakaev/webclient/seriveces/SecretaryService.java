package ru.sakaev.webclient.seriveces;

import ru.sakaev.webclient.entity.Secretary;

import java.util.List;

public interface SecretaryService {
    List<Secretary> getAllSecretaries();
    Secretary getSecretaryById(Long id);
    void createSecretary(Secretary secretary);
    void updateSecretary(Long id, Secretary secretary);
    void deleteSecretary(Long id);
}
