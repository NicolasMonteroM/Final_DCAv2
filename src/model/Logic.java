package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;
import view.Platform;

public class Logic {

	private PApplet app;
	private ArrayList<Player> playerList;
	private ArrayList<Player> playerList2;

	private ArrayList<Enemie> enemies;
	private ArrayList<Enemie> enemies2;
	private ArrayList<Enemie> enemies1;
	private File dataPuntajes;
	private String [] arrayStrings;
	private String [] array2;

	private String nickname, date;
	private int score, time;


	public Logic(PApplet app) {
		this.app = app;
		arrayStrings = app.loadStrings("../data/dataPuntajes.txt");
		playerList = new ArrayList<Player>();
		playerList2 = new ArrayList<Player>();

		
		for (int i = 0; i < arrayStrings.length; i++) {
			//System.out.println(arrayStrings[i]);
			String lineString = arrayStrings[i];
			String [] players = lineString.split(",");
			
			for (int j = 0; j < players.length; j++) {


				nickname = players[0];
				score = Integer.parseInt(players[1]);
				time = Integer.parseInt(players[2]);
				date = players[3];
				System.out.println(players[j]);

				//System.out.println(playerList2.get(j));
			}
			
			playerList2.add(new Player(nickname, score, time, date,app));
		}
		
		
		
		enemies = new ArrayList<Enemie>();
		enemies2 = new ArrayList<Enemie>();
		enemies1 = new ArrayList<Enemie>();
	}

	public void createPlayer(String nickname) {
		Player newPlayer = new Player(nickname, app);
		playerList.add(newPlayer);

	}

	public void createEnemies() {

		// lvl 1

		enemies1.add(new EvilDot(app, 50, 50));
		enemies1.add(new EvilDot(app, 55, 50));
		enemies1.add(new EvilDot(app, 60, 50));
		enemies1.add(new EvilDot(app, 65, 50));
		enemies1.add(new EvilDot(app, 70, 50));
		enemies1.add(new Cube(app, 100, 60, 20, 20));
		enemies1.add(new Cube(app, 120, 60, 20, 20));
		enemies1.add(new Cube(app, 140, 60, 20, 20));

		// lvl 2
		/*
		 * enemies2.add(new EvilDot()); enemies2.add(new EvilDot()); enemies2.add(new
		 * EvilDot()); enemies2.add(new EvilDot()); enemies2.add(new EvilDot());
		 * enemies2.add(new Cube()); enemies2.add(new Cube()); enemies2.add(new Cube());
		 */

		// lvl 3
		/*
		 * enemies.add(new EvilDot()); enemies.add(new EvilDot()); enemies.add(new
		 * EvilDot()); enemies.add(new EvilDot()); enemies.add(new EvilDot());
		 * enemies.add(new Cube()); enemies.add(new Cube()); enemies.add(new Cube());
		 */

	}

	public void drawEnemies() {

		for (Enemie e : enemies1) {

			e.drawEnemie();

		}

	}

	

	public void naturalOrder() {
		Collections.sort(playerList2);

	}

	public void drawLeaders() {
		
		for (int i = 0; i < 5; i++) {
			app.fill(255);
			app.text(playerList2.get(i).getNickname(), 130,200 + (i * 30));
			app.text(playerList2.get(i).getScore(), 280,200 + (i * 30));
			app.text(playerList2.get(i).getTime(), 430,200 + (i * 30));
			app.text(playerList2.get(i).getDate(), 580,200 + (i * 30));

					}
	}
}
