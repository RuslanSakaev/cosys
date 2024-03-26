package ru.sakaev.webclient.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "competitions")
public class Competition {

    @Id
    private String id;

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;

}
