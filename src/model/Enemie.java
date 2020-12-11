package model;

import processing.core.PApplet;

public abstract class Enemie implements Runnable{
	
	protected int posX, posY;
	
	protected PApplet app;

	public Enemie(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
		
	}
	
	public void drawEnemie() {
		
		
	}
	
	public void movement() {
		
		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
