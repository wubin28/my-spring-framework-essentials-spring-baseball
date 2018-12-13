package com.example.baseball.domain;

public interface Game {
    Team getHomeTeam();

    Team getAwayTeam();

    String playGame();

    void setAwayTeam(Team royals);

}
