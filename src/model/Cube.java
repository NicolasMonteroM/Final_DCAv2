package model;

import processing.core.PApplet;

public class Cube extends Enemie{
	
	protected int sizeX, sizeY, rangeX, rangeY;
	protected float h;

	public Cube(PApplet app, int posX, int posY, int sizeX, int sizeY) {
		super(app, posX, posY);
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.rangeX = (int) app.random (1,3);
		this.rangeY = (int) app.random (1,3);
		this.h = 0;
	}

	@Override
	public void run() {
		movement();
		
	}

	@Override
	public void movement(){
		
		sizeX += rangeX;
		sizeY += rangeY;
		
		if (sizeY >= 80 || sizeY <= 20) {
			rangeY *= -1;
		}

		if (sizeX >= 80 || sizeX <= 20) {
			rangeX *= -1;
		}
		
	}
	
	@Override
	public void drawEnemie(){
		if (h > 360) {
			h = 0;
		}

		h += 2;

		app.ellipseMode(app.CENTER);
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
