package ru.sakaev.webclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakaev.webclient.entity.Judge;

public interface JudgeRepository extends JpaRepository<Judge, Long> {
}
