package ru.sakaev.webclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.webclient.entity.Secretary;

public interface SecretaryRepository extends JpaRepository<Secretary, Long> {
}
