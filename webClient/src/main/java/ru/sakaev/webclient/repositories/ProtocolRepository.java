package ru.sakaev.webclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.webclient.entity.Protocol;

public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
}
