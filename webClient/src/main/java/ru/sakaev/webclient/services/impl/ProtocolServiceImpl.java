package ru.sakaev.webclient.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Protocol;
import ru.sakaev.webclient.services.ProtocolService;

@Service
public class ProtocolServiceImpl implements ProtocolService {

    private static final String PROTOCOLS_ENDPOINT = "/protocols";
    private static final String PROTOCOL_BY_ID_ENDPOINT = PROTOCOLS_ENDPOINT + "/{id}";

    private final WebClient webClient;

    public ProtocolServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Protocol> getProtocolById(Long id) {
        return webClient.get()
                .uri(PROTOCOL_BY_ID_ENDPOINT, id)
                .retrieve()
                .bodyToMono(Protocol.class);
    }

    @Override
    public Mono<Void> createProtocol(Protocol protocol) {
        return webClient.post()
                .uri(PROTOCOLS_ENDPOINT)
                .bodyValue(protocol)
                .retrieve()
                .bodyToMono(Void.class)
                .then();
    }

    @Override
    public Mono<Void> updateProtocol(Long id, Protocol protocol) {
        return webClient.put()
                .uri(PROTOCOL_BY_ID_ENDPOINT, id)
                .bodyValue(protocol)
                .retrieve()
                .bodyToMono(Void.class)
                .then();
    }

    @Override
    public Mono<Void> deleteProtocol(Long id) {
        return webClient.delete()
                .uri(PROTOCOL_BY_ID_ENDPOINT, id)
                .retrieve()
                .bodyToMono(Void.class)
                .then();
    }

    @Override
    public Flux<Protocol> getAllProtocols() {
        return webClient.get()
                .uri(PROTOCOLS_ENDPOINT)
                .retrieve()
                .bodyToFlux(Protocol.class);
    }
}
