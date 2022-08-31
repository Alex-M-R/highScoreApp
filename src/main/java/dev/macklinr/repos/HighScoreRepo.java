package dev.macklinr.repos;

import dev.macklinr.entities.Highscore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighScoreRepo extends JpaRepository<Highscore, Integer>
{
    List<Highscore> findByOrderByPointsDesc();

    List<Highscore> findByOrderByInitialsAscPointsDesc();
}
