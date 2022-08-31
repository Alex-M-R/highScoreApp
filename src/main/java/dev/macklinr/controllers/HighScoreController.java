package dev.macklinr.controllers;

import dev.macklinr.entities.Highscore;
import dev.macklinr.services.HighScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;


@Controller
public class HighScoreController
{
    @Autowired
    HighScoreService scoreService;

    Logger logger = LogManager.getLogger(HighScoreController.class);
    // create
    @PostMapping("/scores")
    @ResponseBody
    public ResponseEntity<Highscore> registerScore(@RequestBody Highscore body)
    {
        return new ResponseEntity<Highscore>(this.scoreService.registerScore(body), HttpStatus.CREATED);
    }
    // read
    @GetMapping("/scores")
    @ResponseBody
    public List<Highscore> allScores(@RequestParam(required = false) String alphabetize)
    {

        if (alphabetize == null)
            return this.scoreService.getScores();
        else
            return this.scoreService.getScoresAlphabetized();
    }

    // update
    @PutMapping("/scores/{id}")
    @ResponseBody
    public Highscore updateScore(@RequestBody Highscore body, @PathVariable String id)
    {
        int scoreId = Integer.parseInt(id);
        body.setId(scoreId);
        return this.scoreService.registerScore(body);
    }

    // delete
    @DeleteMapping("/scores/{id}")
    public void deleteScore(@PathVariable String id)
    {
        int scoreId = Integer.parseInt(id);
        this.scoreService.deleteScore(scoreId);
    }

}
