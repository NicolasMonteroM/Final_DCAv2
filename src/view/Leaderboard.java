package view;

import controlP5.ControlP5;
import controller.Controller;
import processing.core.PApplet;

public class Leaderboard {
	private PApplet app;
	private Controller controller;
	private ControlP5 cp5;

	public Leaderboard(PApplet app) {
		this.app = app;
		cp5 = new ControlP5(app);

		cp5.addButton("Back").setPosition(350, 365).setSize(70, 30).setColorBackground(app.color(255, 255, 255, 1))
				.setColorForeground(app.color(255, 255, 255, 20)).setColorActive(app.color(255, 255, 255, 60))
				.getCaptionLabel().hide();

	}

	public void drawScreen() {
		app.background(0);
		app.fill(240);
		app.text("LEADERBOARD", 340, 120);
		app.text("Nickname", 130, 170);
		app.text("Score", 280, 170);
		app.text("Time", 430, 170);
		app.text("Date", 580, 170);
		app.text("BACK", 370, 385);


	}

	public String changeScreen() {
		String screen = "leaderboard";

		if (app.mousePressed && app.mouseX > 333 && app.mouseX < 438 && app.mouseY > 365 && app.mouseY < 395) {
			screen = "register";
		}
		return screen;

	}

	public ControlP5 getCp5() {
		return cp5;
	}

}