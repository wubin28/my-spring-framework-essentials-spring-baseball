package com.example.baseball;

import com.example.baseball.config.AppConfig;
import com.example.baseball.domain.Game;
import com.example.baseball.domain.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RunDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Game game = context.getBean("game", Game.class);
        System.out.println(game.playGame());

        Team royals = context.getBean("royals", Team.class);
        game.setAwayTeam(royals);
        System.out.println(game.playGame());

        System.out.println("--- Bean Definition Names:\n" + Arrays.stream(context.getBeanDefinitionNames()).map(name -> name.toString()).collect(Collectors.joining("\n")));
    }
}
