package ru.sakaev.webclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Competition;
import ru.sakaev.webclient.services.CompetitionService;

import java.util.Optional;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public ResponseEntity<Flux<Competition>> getAllCompetitions() {
        Flux<Competition> competitions = competitionService.getAllCompetitions();
        return new ResponseEntity<>(competitions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mono<Competition>> createCompetition(@RequestBody Competition competition) {
        Mono<Competition> createdCompetition = competitionService.createCompetition(competition);
        return new ResponseEntity<>(createdCompetition, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Competition>> getCompetitionById(@PathVariable Long id) {
        Mono<Competition> competitionMono = competitionService.getCompetitionById(id);
        return competitionMono.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Competition>> updateCompetition(@PathVariable Long id, @RequestBody Competition competition) {
        Mono<Competition> updatedCompetitionMono = competitionService.updateCompetition(id, competition)
                .then(Mono.just(competition)); // Преобразуем Mono<Void> в Mono<Competition>
        return updatedCompetitionMono.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteCompetition(@PathVariable Long id) {
        Mono<Void> deletionResult = competitionService.deleteCompetition(id);
        return new ResponseEntity<>(deletionResult, HttpStatus.NO_CONTENT);
    }

}
