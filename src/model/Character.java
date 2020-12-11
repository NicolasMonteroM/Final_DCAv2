package model;

public class Character {
	
	protected int posX, posY, lives;

	public Character(int posX, int posY, int lives) {
		this.posX = posX;
		this.posY = posY;
		this.lives = 3;
		
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
