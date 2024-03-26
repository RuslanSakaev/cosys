package ru.sakaev.webclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.webclient.entity.Secretary;
import ru.sakaev.webclient.repositories.SecretaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SecretaryService {

    private final SecretaryRepository secretaryRepository;

    @Autowired
    public SecretaryService(SecretaryRepository secretaryRepository) {
        this.secretaryRepository = secretaryRepository;
    }

    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }

    public Optional<Secretary> getSecretaryById(Long id) {
        return secretaryRepository.findById(id);
    }

    public Secretary createSecretary(Secretary secretary) {
        return secretaryRepository.save(secretary);
    }

    public void updateSecretary(Long id, Secretary secretary) {
        secretary.setId(id);
        secretaryRepository.save(secretary);
    }

    public void deleteSecretary(Long id) {
        secretaryRepository.deleteById(id);
    }
}
