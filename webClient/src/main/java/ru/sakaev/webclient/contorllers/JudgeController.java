package ru.sakaev.webclient.contorllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sakaev.webclient.entity.Judge;
import ru.sakaev.webclient.services.JudgeService;

import java.util.List;

@Controller
public class JudgeController {

    private final JudgeService judgeService;

    @Autowired
    public JudgeController(JudgeService judgeService) {
        this.judgeService = judgeService;
    }

    @GetMapping("/judges")
    public String getJudges(Model model) {
        List<Judge> judges = judgeService.getAllJudges();
        model.addAttribute("judges", judges);
        return "judges";
    }
}
