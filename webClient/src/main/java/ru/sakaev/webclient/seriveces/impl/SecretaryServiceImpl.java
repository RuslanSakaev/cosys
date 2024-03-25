package ru.sakaev.webclient.seriveces.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Secretary;
import ru.sakaev.webclient.seriveces.SecretaryService;

import java.util.List;

@Service
public abstract class SecretaryServiceImpl implements SecretaryService {

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
    public List<Secretary> getAllSecretaries() {
        return webClient.get()
                .uri("/secretaries")
                .retrieve()
                .bodyToFlux(Secretary.class)
                .collectList()
                .block();
    }

    // Реализация других методов
}