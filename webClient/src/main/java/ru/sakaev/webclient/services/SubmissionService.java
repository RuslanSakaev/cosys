package ru.sakaev.webclient.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Submission;

public interface SubmissionService {

    Flux<Submission> getAllSubmissions();

    Mono<Submission> getSubmissionById(Long id);

    Flux<Submission> getSubmissionsByUserId(Long userId);

    Flux<Submission> getSubmissionsByProblemId(Long problemId);

    Mono<Submission> createSubmission(Submission submission);

    Mono<Submission> updateSubmission(Long id, Submission submission);

    Mono<Void> deleteSubmission(Long id);
}
