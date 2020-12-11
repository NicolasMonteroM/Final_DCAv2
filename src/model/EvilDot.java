package model;

import processing.core.PApplet;

public class EvilDot extends Enemie {

	protected int size;

	public EvilDot(PApplet app, int posX, int posY) {
		super(app, posX, posY);
		this.size = 5;

	}

	@Override
	public void run() {


	}

	@Override
	public void movement() {

	}
	
	@Override
	public void drawEnemie() {
		app.fill(255);
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
