package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import processing.core.PApplet;

public class Player implements Comparable<Player> {
	private String nickname, date;
	private int score, time;
	private DateTimeFormatter dtf;
	private PApplet app;
	
	public Player(String nickname, PApplet app) {
		this.app= app;
		time = 0;
		//time = (int) app.millis()/1000;
		date = getDateNow();
		score = 0;
	}
	
	public Player(String nickname, int score, int time, String date, PApplet app) {
		this.app=app;
		this.nickname = nickname;
		this.score = score;
		this.time = time;
		this.date = date;



	}

	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDateNow() {
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}


	public int compareTo(Player o1) {
		// TODO Auto-generated method stub
		return o1.getScore()-score;
	}
	

	public void drawOnLevel(int time, int score) {
		app.fill(240);
		app.text("SCORE: " + score, 400, 120);
		app.text("TIME" + time + "s", 500, 120);
	}
	
	public String getDate() {
		return date;
	}
	public int getScore() {
		return score;
	}
	
	public int getTime() {
		return time;
	}
	
	
}