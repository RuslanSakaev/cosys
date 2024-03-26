package ru.sakaev.webclient.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@Document(collection = "submissions")
public class Submission {

    // Getters and Setters
    @Id
    private String id;

    private String userId;
    private String problemId;
    private String language;
    private String code;
    private LocalDateTime submissionTime;
    private boolean evaluated;
    private String evaluationResult;

    // Constructors, getters, and setters
    // Constructor
    public Submission() {
        this.submissionTime = LocalDateTime.now();
        this.evaluated = false;
    }

}
