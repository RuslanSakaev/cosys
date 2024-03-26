package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Secretary;
import ru.sakaev.webclient.services.SecretaryService;

import java.util.List;

@Service
public class SecretaryServiceImpl implements SecretaryService {

    private final WebClient webClient;

    public SecretaryServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Secretary getSecretaryById(Long id) {
        return webClient.get()
                .uri("/secretaries/{id}", id)
                .retrieve()
                .bodyToMono(Secretary.class)
                .block();
    }

    @Override
    public Secretary createSecretary(Secretary secretary) {
        // Implement your logic for creating a secretary
        return secretary;
    }

    @Override
    public void updateSecretary(Long id, Secretary secretary) {
        // Implement your logic for updating a secretary
    }

    @Override
    public void deleteSecretary(Long id) {
        // Implement your logic for deleting a secretary
    }

    @Override
    public List<Secretary> getAllSecretaries() {
        return webClient.get()
                .uri("/secretaries")
                .retrieve()
                .bodyToFlux(Secretary.class)
                .collectList()
                .block();
    }
}
