package dev.macklinr.services;

import dev.macklinr.entities.Highscore;
import dev.macklinr.exceptions.NegativeScoreException;
import dev.macklinr.exceptions.ScoreNotFoundException;
import dev.macklinr.repos.HighScoreRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HighScoreServiceImplementation implements HighScoreService {
   @Autowired
    HighScoreRepo highScoreRepo;

   Logger logger = LogManager.getLogger(HighScoreServiceImplementation.class);

    @Override
    public Highscore registerScore(Highscore score) // create AND update since it enforces business rules.
    {
        // check score isn't negative
        if (score.getPoints() < 0)
            throw new NegativeScoreException();

        // force 3 character max for initials, and upper case
        String initials = score.getInitials().toUpperCase();
        if (initials.length() > 3)
            initials = score.getInitials().substring(0, 3);

        score.setInitials(initials);
        return this.highScoreRepo.save(score);
    }

    @Override
    public List<Highscore> getScores()
    {
        return this.highScoreRepo.findByOrderByPointsDesc();
//        return this.highScoreRepo.findAll();
    }

    @Override
    public List<Highscore> getScoresAlphabetized() {
        return this.highScoreRepo.findByOrderByInitialsAscPointsDesc();
    }

    @Override
    public Highscore getScoreById(int id) {
        Optional<Highscore> possibleScore = this.highScoreRepo.findById(id);

        if (possibleScore.isPresent())
            return possibleScore.get();
        else
            throw new ScoreNotFoundException();
      //  return this.scoreRepo.findById(id);
    }

    @Override
    public boolean deleteScore(int id) {
        try
        {
            this.highScoreRepo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e)

        {
            this.logger.error("A high score with id " + id + " could not be found.");
            throw new ScoreNotFoundException();
        }

       return true;
    }
}
