package model;

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

	public Logic(PApplet app) {
		this.app = app;

		enemies = new ArrayList<Enemie>();
		enemies2 = new ArrayList<Enemie>();
		enemies1 = new ArrayList<Enemie>();
	}

	public void createPlayer(String nickname, PApplet app) {
		Player newPlayer = new Player(nickname, app);
		playerList.add(newPlayer);

	}

	public void createEnemies() {

		// lvl 1

		enemies1.add(new EvilDot());
		enemies1.add(new EvilDot());
		enemies1.add(new EvilDot());
		enemies1.add(new EvilDot());
		enemies1.add(new EvilDot());
		enemies1.add(new Cube());
		enemies1.add(new Cube());
		enemies1.add(new Cube());

		// lvl 2

		enemies2.add(new EvilDot());
		enemies2.add(new EvilDot());
		enemies2.add(new EvilDot());
		enemies2.add(new EvilDot());
		enemies2.add(new EvilDot());
		enemies2.add(new Cube());
		enemies2.add(new Cube());
		enemies2.add(new Cube());
		
		// lvl 3

		enemies.add(new EvilDot());
		enemies.add(new EvilDot());
		enemies.add(new EvilDot());
		enemies.add(new EvilDot());
		enemies.add(new EvilDot());
		enemies.add(new Cube());
		enemies.add(new Cube());
		enemies.add(new Cube());

	}

	public void naturalOrder() {
		Collections.sort(playerList);

	}

	public void drawLeaders() {
		if (playerList.size() != 0) {
			for (int i = 0; i < playerList.size(); i++) {
				app.fill(0);
				app.text(playerList.get(i).getScore() + "                               " + playerList.get(i).getTime()
						+ "                              " + playerList.get(i).getDate()
						+ "                              ", 100, 100 + (i * 20));
			}
		}

		else {
			System.out.println("Vacio");
		}
	}

}
