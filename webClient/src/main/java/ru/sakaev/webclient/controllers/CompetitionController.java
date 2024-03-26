package ru.sakaev.webclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.sakaev.webclient.entity.Competition;
import ru.sakaev.webclient.services.CompetitionService;

import java.util.List;
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
    public ResponseEntity<Iterable<Competition>> getAllCompetitions() {
        Mono<List<Competition>> competitionMono = competitionService.getAllCompetitions().collectList();
        Iterable<Competition> competitions = competitionMono.block();
        return new ResponseEntity<>(competitions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Competition> createCompetition(@RequestBody Competition competition) {
        Competition createdCompetition = competitionService.createCompetition(competition).block();
        return new ResponseEntity<>(createdCompetition, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable String id) {
        Mono<Competition> competitionMono = competitionService.petitionById(id);
        Optional<Competition> competitionOptional = competitionMono.blockOptional();
        return competitionOptional.map(competition -> new ResponseEntity<>(competition, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> updateCompetition(@PathVariable String id, @RequestBody Competition competition) {
        Mono<Competition> updatedCompetitionMono = competitionService.updateCompetition(id, competition);
        Competition updatedCompetition = updatedCompetitionMono.block();
        return new ResponseEntity<>(updatedCompetition, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable String id) {
        competitionService.deleteCompetition(id).block();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
