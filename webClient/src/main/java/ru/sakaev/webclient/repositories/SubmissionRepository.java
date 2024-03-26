package ru.sakaev.webclient.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ru.sakaev.webclient.entity.Submission;
public interface SubmissionRepository extends ReactiveCrudRepository<Submission, Long> {
    Flux<Submission> findByProblemId(Long problemId);

    Flux<Submission> findByUserId(Long userId);
}
