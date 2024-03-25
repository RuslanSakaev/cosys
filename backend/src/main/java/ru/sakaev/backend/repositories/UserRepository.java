package ru.sakaev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
