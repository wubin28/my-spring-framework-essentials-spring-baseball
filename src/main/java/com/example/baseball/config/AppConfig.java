package com.example.baseball.config;

import com.example.baseball.domain.BaseballGame;
import com.example.baseball.domain.Game;
import com.example.baseball.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.example.baseball")
public class AppConfig {

    @Autowired
    private List<Team> teams;

    @Bean
    @Scope("prototype")
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(teams.get(0), teams.get(1));
        return baseballGame;
    }
}
