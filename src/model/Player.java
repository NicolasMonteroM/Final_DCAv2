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
		time = (int) app.millis()/1000;
		date = getDate();
		score = 0;
	}
	

	public String getDate() {
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
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
	
	public int getScore() {
		return score;
	}
	
	public int getTime() {
		return time;
	}
	
	
}