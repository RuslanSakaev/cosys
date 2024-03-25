package ru.sakaev.webclient.contorllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sakaev.webclient.entity.Competition;
import ru.sakaev.webclient.services.CompetitionService;

import java.util.List;

@Controller
public class CompetitionController {
    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/competitions")
    public String getCompetitions(Model model) {
        // Логика для получения данных о соревнованиях от сервера

        List<Competition> competitions = competitionService.getAllCompetitions();
        model.addAttribute("competitions", competitions);
        return "competitions"; // Возвращаем имя шаблона Thymeleaf
    }
}

