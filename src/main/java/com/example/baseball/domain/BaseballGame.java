package com.example.baseball.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

public class BaseballGame implements Game{

	private Team homeTeam;
	private Team awayTeam;
	private DataSource dataSource;

	public BaseballGame(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	@PostConstruct
	public void startGame() {
		System.out.println("Playing National Athem");
	}

	@PreDestroy
	public void endGame() {
		System.out.println("Sending highlight to MLB");
	}

	@Override
	public Team getHomeTeam() {
		return this.homeTeam;
	}

	@Override
	public Team getAwayTeam() {
		return this.awayTeam;
	}

	@Override
	public String playGame() {
		return Math.random() < 0.5 ? getHomeTeam().getName() :
				getAwayTeam().getName();
	}

	@Override
	public void setAwayTeam(Team royals) {
		this.awayTeam = royals;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public String toString() {
		return String.format("Game between %s at %s", awayTeam.getName(), homeTeam.getName());
	}
}
