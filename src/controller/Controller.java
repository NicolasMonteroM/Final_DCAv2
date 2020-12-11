package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {

	private Logic logic;
	private PApplet app;

	public Controller(PApplet app) {
		logic = new Logic(app);

	}

	public void newPlayer(String nickname) {
		logic.createPlayer(nickname);

	}
	
	public void createGame() {
		logic.createEnemies();
		
	}
	
	public void drawGame() {
		logic.drawEnemies();
		
	}

	public void naturalOrder() {
		logic.naturalOrder();
	}

	public void drawLeaders() {
		logic.drawLeaders();
	}

}