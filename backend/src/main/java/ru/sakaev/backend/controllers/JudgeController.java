package ru.sakaev.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sakaev.backend.model.Judge;
import ru.sakaev.backend.service.JudgeService;

import java.util.List;

@RestController
@RequestMapping("/api/judges")
public class JudgeController {

    private final JudgeService judgeService;

    @Autowired
    public JudgeController(JudgeService judgeService) {
        this.judgeService = judgeService;
    }

    @PostMapping
    public ResponseEntity<Judge> createJudge(@RequestBody Judge judge) {
        Judge createdJudge = judgeService.createJudge(judge);
        return new ResponseEntity<>(createdJudge, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Judge> getJudgeById(@PathVariable Long id) {
        Judge judge = judgeService.getJudgeById(id).orElse(null);
        if (judge != null) {
            return new ResponseEntity<>(judge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Judge>> getAllJudges() {
        List<Judge> judges = judgeService.getAllJudges();
        return new ResponseEntity<>(judges, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Judge> updateJudge(@PathVariable Long id, @RequestBody Judge judge) {
        Judge updatedJudge = judgeService.updateJudge(id, judge);
        return new ResponseEntity<>(updatedJudge, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJudge(@PathVariable Long id) {
        judgeService.deleteJudgeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
