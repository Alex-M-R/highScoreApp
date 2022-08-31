package dev.macklinr.app;

import dev.macklinr.entities.Highscore;
import dev.macklinr.repos.HighScoreRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // can annotate the test class to make all methods transactional (All CRUD operations will not persist outside the test)
public class ScoreRepoTests
{
    @Autowired
    HighScoreRepo scoreRepo;

    @Test
    void add_score()
    {
        Highscore score = new Highscore(0, "AAA", 1000);
        Highscore savedScore = this.scoreRepo.save(score);
        Assertions.assertNotEquals(0, savedScore.getId());
    }

}
