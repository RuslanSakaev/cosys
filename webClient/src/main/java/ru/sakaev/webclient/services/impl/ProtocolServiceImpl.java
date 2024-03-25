package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.sakaev.webclient.entity.Protocol;
import ru.sakaev.webclient.services.ProtocolService;

import java.util.List;

@Service
public class ProtocolServiceImpl implements ProtocolService {

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
    public void createProtocol(Protocol protocol) {

    }

    @Override
    public void updateProtocol(Long id, Protocol protocol) {

    }

    @Override
    public void deleteProtocol(Long id) {

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