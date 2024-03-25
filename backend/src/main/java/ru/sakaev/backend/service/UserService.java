package ru.sakaev.backend.service;

import ru.sakaev.backend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User updateUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByUsername(String username);
}
