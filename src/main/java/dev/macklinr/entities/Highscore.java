package dev.macklinr.entities;

import javax.persistence.*;

@Entity
@Table(name = "highscore")
public class Highscore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "initials")
    String initials;
    @Column(name = "points")
    int points;

    public Highscore() {
    }

    public Highscore(int id, String initials, int points) {
        this.id = id;
        this.initials = initials;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Highscore{" +
                "id=" + id +
                ", initials='" + initials + '\'' +
                ", points=" + points +
                '}';
    }
}
