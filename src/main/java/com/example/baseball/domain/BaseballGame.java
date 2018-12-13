package com.example.baseball.domain;

public class BaseballGame implements Game{

	private Team homeTeam;
	private Team awayTeam;

	public BaseballGame(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
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
