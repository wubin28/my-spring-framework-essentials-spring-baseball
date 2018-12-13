package com.example.baseball.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.baseball")
public class AppConfig {

//    @Autowired
//    @Qualifier("redSox")
//    private Team home;
//
//    @Autowired
//    @Qualifier("cubs")
//    private Team away;
//
//    @Bean
//    @Scope("prototype")
//    public Game game() {
//        BaseballGame baseballGame = new BaseballGame(home, away);
//        return baseballGame;
//    }
}
