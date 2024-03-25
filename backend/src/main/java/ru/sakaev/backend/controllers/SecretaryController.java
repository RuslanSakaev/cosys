package ru.sakaev.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sakaev.backend.service.SecretaryService;

@RestController
@RequestMapping("/secretaries")
public class SecretaryController {

    private final SecretaryService secretaryService;

    @Autowired
    public SecretaryController(SecretaryService secretaryService) {
        this.secretaryService = secretaryService;
    }

    // Методы обработки запросов для секретарей
}