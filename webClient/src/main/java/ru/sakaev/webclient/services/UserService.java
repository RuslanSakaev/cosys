package ru.sakaev.webclient.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.User;

public interface UserService {
    Mono<User> createUser(User user);
    Flux<User> getAllUsers();
    Mono<User> updateUser(String id, User user);
    Mono<Void> deleteUser(String id);
    Mono<User> getUserById(String id);
}
