package ru.sakaev.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sakaev.backend.model.Secretary;
import ru.sakaev.backend.service.SecretaryService;

import java.util.List;

@RestController
@RequestMapping("/api/secretaries")
public class SecretaryController {

    private final SecretaryService secretaryService;

    @Autowired
    public SecretaryController(SecretaryService secretaryService) {
        this.secretaryService = secretaryService;
    }

    @PostMapping
    public ResponseEntity<Secretary> createSecretary(@RequestBody Secretary secretary) {
        Secretary createdSecretary = secretaryService.createSecretary(secretary);
        return new ResponseEntity<>(createdSecretary, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Secretary> getSecretaryById(@PathVariable Long id) {
        Secretary secretary = secretaryService.getSecretaryById(id).orElse(null);
        if (secretary != null) {
            return new ResponseEntity<>(secretary, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Secretary>> getAllSecretaries() {
        List<Secretary> secretaries = secretaryService.getAllSecretaries();
        return new ResponseEntity<>(secretaries, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Secretary> updateSecretary(@PathVariable Long id, @RequestBody Secretary secretary) {
        Secretary updatedSecretary = secretaryService.updateSecretary(id, secretary);
        return new ResponseEntity<>(updatedSecretary, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecretary(@PathVariable Long id) {
        secretaryService.deleteSecretaryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
