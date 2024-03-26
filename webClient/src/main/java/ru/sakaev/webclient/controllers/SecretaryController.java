package ru.sakaev.webclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sakaev.webclient.entity.Secretary;
import ru.sakaev.webclient.services.SecretaryService;

import java.util.List;

@Controller
public class SecretaryController {

    private final SecretaryService secretaryService;

    @Autowired
    public SecretaryController(SecretaryService secretaryService) {
        this.secretaryService = secretaryService;
    }

    @GetMapping("/secretaries")
    public String getSecretaries(Model model) {
        List<Secretary> secretaries = secretaryService.getAllSecretaries();
        model.addAttribute("secretaries", secretaries);
        return "secretaries";
    }
}