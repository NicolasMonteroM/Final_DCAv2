package model;

import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;

public class Logic {

	private PApplet app;
	private ArrayList<Player> playerList;

	public Logic(PApplet app) {
		this.app = app;
	}

	public void createPlayer(String nickname, PApplet app) {
		Player newPlayer = new Player(nickname, app);
		playerList.add(newPlayer);

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
