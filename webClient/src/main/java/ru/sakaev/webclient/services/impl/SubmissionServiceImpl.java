package ru.sakaev.webclient.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Submission;
import ru.sakaev.webclient.repositories.SubmissionRepository;
import ru.sakaev.webclient.services.SubmissionService;

@Service
public class SubmissionServiceImpl extends SubmissionService {

    private final SubmissionRepository submissionRepository;

    @Autowired
    public SubmissionServiceImpl(SubmissionRepository submissionRepository) {
        super(submissionRepository); // Передаем submissionRepository в конструктор родительского класса
        this.submissionRepository = submissionRepository;
    }

    @Override
    public Flux<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public Flux<Submission> getSubmissionsByUserId(Long userId) {
        return submissionRepository.findByUserId(userId);
    }

    @Override
    public Flux<Submission> getSubmissionsByProblemId(Long problemId) {
        return submissionRepository.findByProblemId(problemId);
    }

    @Override
    public Mono<Submission> createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public Mono<Submission> updateSubmission(Long id, Submission submission) {
        return submissionRepository.findById(id)
                .flatMap(existingSubmission -> {
                    submission.setId(existingSubmission.getId());
                    return submissionRepository.save(submission);
                });
    }

    @Override
    public Mono<Void> deleteSubmission(Long id) {
        return submissionRepository.deleteById(id);
    }

}
