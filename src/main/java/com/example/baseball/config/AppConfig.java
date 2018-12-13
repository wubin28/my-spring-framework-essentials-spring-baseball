package com.example.baseball.config;

import com.example.baseball.domain.BaseballGame;
import com.example.baseball.domain.Game;
import com.example.baseball.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.example.baseball")
@ImportResource("classpath:/applicationContext.xml")
public class AppConfig {

    @Autowired
    private List<Team> teams;

    @Autowired
    private DataSource dataSource;

    @Bean
    @Scope("prototype")
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(teams.get(0), teams.get(1));
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
}
