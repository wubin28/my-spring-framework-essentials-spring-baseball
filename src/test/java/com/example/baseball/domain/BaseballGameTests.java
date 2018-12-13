package com.example.baseball.domain;

import com.example.baseball.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class BaseballGameTests {

	@Autowired
	private Game game;

	@Autowired
	private ApplicationContext context;

	@Test
	public void should_have_a_winning_team() {
		String home = game.getHomeTeam().getName();
		String away = game.getAwayTeam().getName();

		String result = game.playGame();

		assertTrue(result.contains(home) || result.contains(away));
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

		assertThat(game2.toString(), not(equalTo(game1.toString())));
	}
}
