package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PVector;

public class Personaje extends PApplet {
	
	private PApplet app;
	public PVector posPersonaje;

	PVector vel;
	public boolean choque = false;
	float movimiento;
	float distancia;
	PImage imagen;
	protected int lives;
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	protected float posX, posY;

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public Personaje(PApplet app, float x, float y) {
		this.posX = x;
		this.posY = y;
		this.app = app;
		this.posPersonaje = new PVector(x, y);
		this.vel = new PVector();
		this.movimiento = 0;
		this.distancia = 2;
		this.imagen = app.loadImage("personaje.png");
		this.lives = 3;

	}

	public void pintar() {

		// app.image(imagen,posPersonaje.x,posPersonaje.y-8);
		app.imageMode(CENTER);

		app.image(imagen, posPersonaje.x, posPersonaje.y - 8);
		if (!choque) {
			vel.y += 0.1;
		}

		posPersonaje.add(vel);
		posPersonaje.x += movimiento;
		vel.mult((float) 1);
	}

	public void mover() {
		if (key == 'a') {
			movimiento = -distancia;

		}
		if (key == 'd') {
			movimiento = distancia;

		}

	}

	public void quieto() {
		if (key == 'a') {
			movimiento = 0;

		}
		
		if (key == 'd') {
			movimiento = 0;
		}
	}
}