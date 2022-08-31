package dev.macklinr.services;

import dev.macklinr.entities.Highscore;

import java.util.List;

public interface HighScoreService
{
    Highscore registerScore(Highscore score);
    List<Highscore> getScores();

    List<Highscore> getScoresAlphabetized();
    Highscore getScoreById(int id);
    boolean deleteScore(int id);
}
