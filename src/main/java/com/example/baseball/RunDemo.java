package com.example.baseball;

import com.example.baseball.domain.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RunDemo {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Game game = context.getBean("game", Game.class);
        System.out.println(game.playGame());
        System.out.println("--- Bean Definition Names:\n" + Arrays.stream(context.getBeanDefinitionNames()).map(name -> name.toString()).collect(Collectors.joining("\n")));
    }
}
