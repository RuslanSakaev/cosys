package ru.sakaev.webclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sakaev.webclient.entity.Judge;

@Repository
public interface JudgeRepository extends JpaRepository<Judge, Long> {
}
