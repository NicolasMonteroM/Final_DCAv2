package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

public class Register {

	private PApplet app;
	private Controller controller;
	private PImage register; // BACKGROUND IMAGE
	private ControlP5 cp5;
	private String nickname;
	private boolean canStart = true, start = false;

	public Register(PApplet app) {
		this.app = app;
		register = app.loadImage("Register.png");
		cp5 = new ControlP5(app);

		cp5.addTextfield("Nickname").setPosition(285, 279).setSize(211, 33).setAutoClear(true)
				.setColorActive(app.color(0, 0, 0, 1)).setColorBackground(app.color(0, 0, 0))
				.setColorForeground(app.color(0, 0, 0, 1)).setText("Your nickname").setColor(app.color(100))
				.setColorCursor(app.color(255, 255, 255)).setFont(app.createFont("Anonymous Pro", 12)).getCaptionLabel()
				.hide();

		cp5.addButton("registerNewPlayer").setPosition(350, 330).setSize(70, 30)
				.setColorBackground(app.color(255, 255, 255, 1)).setColorForeground(app.color(255, 255, 255, 20))
				.setColorActive(app.color(255, 255, 255, 60)).getCaptionLabel().hide();

		cp5.addButton("Leaderboard").setPosition(333, 365).setSize(105, 30)
				.setColorBackground(app.color(255, 255, 255, 1)).setColorForeground(app.color(255, 255, 255, 20))
				.setColorActive(app.color(255, 255, 255, 60)).getCaptionLabel().hide();

	}

	public void drawScreen() {
		app.image(register, 0, 0);

	}

	public void registerNewPlayer() {
		if (app.mouseX > 350 && app.mouseX < 420 && app.mouseY > 330 && app.mouseY < 360) {
			start = true;
			nickname = cp5.get(Textfield.class, "Nickname").getText();
			// System.out.println(nickname);

			if (!nickname.equals("")) {
				cp5.get(Textfield.class, "Nickname").setText("");
				canStart = true;
				// controller.newPlayer(nickname, app);

			}
		}
	}

	public String changeScreen() {
		String screen = "register";

		if (app.mousePressed && start && canStart) {
			screen = "level 1";
		}

		if (app.mousePressed && app.mouseX > 333 && app.mouseX < 438 && app.mouseY > 365 && app.mouseY < 395) {
			screen = "leaderboard";
		}
		return screen;

	}

	public ControlP5 getCp5() {
		return cp5;
	}

	public void setCp5(ControlP5 cp5) {
		this.cp5 = cp5;
	}

	public String getNickname() {
		nickname = cp5.get(Textfield.class, "Nickname").getText();
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}