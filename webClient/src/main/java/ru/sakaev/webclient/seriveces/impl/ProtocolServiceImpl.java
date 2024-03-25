package ru.sakaev.webclient.seriveces.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Protocol;
import ru.sakaev.webclient.seriveces.ProtocolService;

import java.util.List;

@Service
public abstract class ProtocolServiceImpl implements ProtocolService {

    private final WebClient webClient;

    public ProtocolServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Protocol getProtocolById(Long id) {
        return webClient.get()
                .uri("/protocols/{id}", id)
                .retrieve()
                .bodyToMono(Protocol.class)
                .block();
    }

    @Override
    public List<Protocol> getAllProtocols() {
        return webClient.get()
                .uri("/protocols")
                .retrieve()
                .bodyToFlux(Protocol.class)
                .collectList()
                .block();
    }

    // Реализация других методов
}