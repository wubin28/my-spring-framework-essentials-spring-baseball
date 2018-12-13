package com.example.baseball;

import com.example.baseball.config.AppConfig;
import com.example.baseball.domain.Game;
import com.example.baseball.domain.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Game game = context.getBean("game", Game.class);
        Team royals = context.getBean("royals", Team.class);
        Team redSox = context.getBean("redSox", Team.class);
        Team cubs = context.getBean("cubs", Team.class);

        game.setHomeTeam(royals);
        game.setAwayTeam(cubs);
        System.out.println(game.playGame());

        game.setHomeTeam(cubs);
        game.setAwayTeam(redSox);
        System.out.println(game.playGame());

        ((AnnotationConfigApplicationContext) context).close();
    }
}
