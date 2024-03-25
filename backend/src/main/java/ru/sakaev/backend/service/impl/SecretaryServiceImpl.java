package ru.sakaev.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakaev.backend.model.Secretary;
import ru.sakaev.backend.repositories.SecretaryRepository;
import ru.sakaev.backend.service.SecretaryService;

import java.util.List;
import java.util.Optional;

@Service
public class SecretaryServiceImpl implements SecretaryService {

    private final SecretaryRepository secretaryRepository;

    @Autowired
    public SecretaryServiceImpl(SecretaryRepository secretaryRepository) {
        this.secretaryRepository = secretaryRepository;
    }

    @Override
    public Secretary createSecretary(Secretary secretary) {
        // Валидация данных перед сохранением
        if (secretary.getName() == null || secretary.getName().isEmpty()) {
            throw new IllegalArgumentException("Secretary name cannot be empty");
        }
        // Дополнительная валидация

        // Сохранение сущности в базе данных
        return secretaryRepository.save(secretary);
    }

    @Override
    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }

    @Override
    public Secretary updateSecretary(Long id, Secretary secretary) {
        // Проверка существования секретаря с указанным id
        if (!secretaryRepository.existsById(id)) {
            throw new IllegalArgumentException("Secretary with id " + id + " does not exist");
        }
        secretary.setId(id); // Установка id для сущности
        return secretaryRepository.save(secretary); // Сохранение обновленной сущности
    }

    @Override
    public void deleteSecretary(Long id) {
        // Проверка существования секретаря с указанным id
        if (!secretaryRepository.existsById(id)) {
            throw new IllegalArgumentException("Secretary with id " + id + " does not exist");
        }
        secretaryRepository.deleteById(id); // Удаление секретаря из базы данных
    }

    @Override
    public Optional<Secretary> getSecretaryById(Long id) {
        return secretaryRepository.findById(id); // Получение секретаря по id
    }

    @Override
    public void deleteSecretaryById(Long id) {
        secretaryRepository.deleteById(id); // Удаление секретаря по id
    }
}