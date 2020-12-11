package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;
import view.Platform;

public class Logic {

	private PApplet app;
	private ArrayList<Player> playerList;

	private ArrayList<Enemie> enemies;
	private ArrayList<Enemie> enemies2;
	private ArrayList<Enemie> enemies1;
	private File dataPuntajes;
	private String [] arrayStrings;

	public Logic(PApplet app) {
		this.app = app;
		arrayStrings = app.loadStrings("../data/dataPuntajes.txt");
		playerList = new ArrayList<Player>();
		
		for (int i = 0; i < arrayStrings.length; i++) {
			String lineString = arrayStrings[i];
			String [] arrayWord = lineString.split(" ");
			Player p = null;
		}
		
		for (int i = 0; i < arrayStrings.length; i++) {
			String[] player = arrayStrings[i].split(","); // separar por comas
			String nickname = player[0];
			int score = Integer.parseInt(player[1]);
			int time = Integer.parseInt(player[2]);
			String date = player[3];
			playerList.add(new Player(nickname, score, time, date));

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
		Collections.sort(playerList);

	}

	public void drawLeaders() {
		
		for (int i = 0; i < playerList.size(); i++) {
			app.fill(0);
			app.text(playerList.get(i).getNickname() + "                                    " + playerList.get(i).getScore() + "                                    " + 
			playerList.get(i).getTime() + "                                    " + playerList.get(i).getDate(), 100,100 + (i * 20));
		}
	}
}
