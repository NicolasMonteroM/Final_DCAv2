package model;

import processing.core.PApplet;

public class Cube extends Enemie{
	
	protected int sizeX, sizeY;
	protected float h;

	public Cube(PApplet app, int posX, int posY, int sizeX, int sizeY) {
		super(app, posX, posY);
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.h = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movement(){
		
		
	}
	
	@Override
	public void drawEnemie(){
		if (h > 360) {
			h = 0;
		}

		h += 2;

		app.fill(h, 360, 360);
		app.noStroke();
		app.rect(posX, posY, sizeX, sizeY);
		
	}
	
	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}


}
