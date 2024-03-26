package ru.sakaev.webclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Submission;
import ru.sakaev.webclient.repositories.SubmissionRepository;

@Service
public abstract class SubmissionService {

    private final SubmissionRepository submissionRepository;

    @Autowired
    protected SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }
    public Flux<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Mono<Submission> getSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    public abstract Flux<Submission> getSubmissionsByUserId(Long userId);

    public abstract Flux<Submission> getSubmissionsByProblemId(Long problemId);

    public Mono<Submission> createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    public Mono<Submission> updateSubmission(Long id, Submission submission) {
        return submissionRepository.findById(id)
                .flatMap(existingSubmission -> {
                    submission.setId(existingSubmission.getId());
                    return submissionRepository.save(submission);
                });
    }

    public Mono<Void> deleteSubmission(Long id) {
        return submissionRepository.deleteById(id);
    }
}
