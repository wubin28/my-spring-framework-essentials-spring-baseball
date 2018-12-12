package com.example.baseball.domain;

import com.example.baseball.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
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
}
