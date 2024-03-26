package ru.sakaev.webclient.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.User;
import ru.sakaev.webclient.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_ENDPOINT = "/users";
    private static final String USER_BY_ID_ENDPOINT = "/users/{id}";

    private final WebClient webClient;

    @Autowired
    public UserServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<User> createUser(User user) {
        return webClient.post()
                .uri(USERS_ENDPOINT)
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(User.class);
    }

    @Override
    public Flux<User> getAllUsers() {
        return webClient.get()
                .uri(USERS_ENDPOINT)
                .retrieve()
                .bodyToFlux(User.class);
    }

    @Override
    public Mono<User> updateUser(String id, User user) {
        return webClient.put()
                .uri(USER_BY_ID_ENDPOINT, id)
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(User.class);
    }

    @Override
    public Mono<Void> deleteUser(String id) {
        return webClient.delete()
                .uri(USER_BY_ID_ENDPOINT, id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    @Override
    public Mono<User> getUserById(String id) {
        return webClient.get()
                .uri(USER_BY_ID_ENDPOINT, id)
                .retrieve()
                .bodyToMono(User.class);
    }
}
