package com.example.baseball.domain;

import javax.sql.DataSource;

public class BaseballGame implements Game{

	private Team homeTeam;
	private Team awayTeam;
	private DataSource dataSource;

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
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
}
