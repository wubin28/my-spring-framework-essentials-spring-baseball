package com.example.baseball.domain;

import com.example.baseball.config.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class BaseballGameTests {

    private Game game;

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        game = context.getBean("game", Game.class);
    }

    @Test
    public void should_have_a_winning_team() {
        String home = game.getHomeTeam().getName();
        String away = game.getAwayTeam().getName();

        String result = game.playGame();

        assertTrue(result == null || result.contains(home) || result.contains(away));
    }

    @Test
    public void should_get_a_bean_from_application_context() {
        Team royals = context.getBean("royals", Team.class);
        assertEquals("Kansas City Royals", royals.getName());
    }

    @Test
    public void by_default_all_spring_managed_beans_are_singletons() {

        Game game1 = context.getBean("game", Game.class);

        Game game2 = context.getBean("game", Game.class);
        game2.setAwayTeam(context.getBean("royals", Team.class));

        assertThat(game2.toString(), is(game1.toString()));
    }
}
