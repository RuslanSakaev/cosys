package ru.sakaev.webclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.webclient.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
