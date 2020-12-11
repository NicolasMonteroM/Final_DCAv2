package model;

import processing.core.PApplet;

public class EvilDot extends Enemie {

	protected int size, speed, dir;
	public float h;

	public EvilDot(PApplet app, int posX, int posY) {
		super(app, posX, posY);
		this.h = 0;
		this.size = 8;
		this.speed = (int) app.random(2,5);
		this.dir = 1;

	}

	@Override
	public void run() {

		movement();

	}

	@Override
	public void movement() {

		posY += speed * dir;

		if (posY >= 430 && posY > 310 || posY < 310) {
			dir *= -1;
		}

	}

	@Override
	public void drawEnemie() {

		if (h > 360) {
			h = 0;
		}

		h += 2;

		app.fill(h, 360, 360);

		app.noStroke();
		app.ellipse(posX, posY, size, size);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
