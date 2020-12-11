package model;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Enemie implements Runnable{
	
	protected int posX, posY;
	
	protected PApplet app;
	
	PVector pos;
	
	private float w;

	public Enemie(PApplet app, int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
		pos = new PVector(posX, posY);
		
	}
	
	public void drawEnemie() {
		
		
	}
	
	public void movement() {
		
		
	}
	
	public boolean collide(PVector p) {
		if (p.x > pos.x && p.y > pos.y && p.x < pos.x + w && p.y < pos.y + 10) {
			return true;
		}
		return false;
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
