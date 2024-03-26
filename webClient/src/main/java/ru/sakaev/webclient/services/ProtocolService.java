package ru.sakaev.webclient.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Protocol;

public interface ProtocolService {

    Mono<Protocol> getProtocolById(Long id);

    Mono<Void> createProtocol(Protocol protocol);

    Mono<Void> updateProtocol(Long id, Protocol protocol);

    Mono<Void> deleteProtocol(Long id);

    Flux<Protocol> getAllProtocols();
}
