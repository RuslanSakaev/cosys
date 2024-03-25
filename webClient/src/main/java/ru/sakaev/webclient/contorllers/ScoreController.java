package ru.sakaev.webclient.contorllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sakaev.webclient.entity.Score;
import ru.sakaev.webclient.services.ScoreService;

import java.util.List;

@Controller
public class ScoreController {

    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/scores")
    public String getScores(Model model) {
        List<Score> scores = scoreService.getAllScores();
        model.addAttribute("scores", scores);
        return "scores";
    }
}