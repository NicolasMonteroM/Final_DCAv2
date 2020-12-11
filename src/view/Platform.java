package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

public class Platform extends PApplet {
	private PApplet app;
	public float h = 0;

	PVector pos;

	private float w;

	Platform(float x, float y, float w, PApplet app) {
		this.app = app;
		this.w = w;
		pos = new PVector(x, y);
	}

	public void show() {

		if (h > 360) {
			h = 0;
		}

		h += 2;

		this.app.strokeWeight(2);
		this.app.stroke(h, 360, 360);
		this.app.line(pos.x, pos.y, pos.x + w, pos.y);

	}

	public boolean collide(PVector p) {
		if (p.x > pos.x && p.y > pos.y && p.x < pos.x + w && p.y < pos.y + 10) {
			return true;
		}
		return false;
	}

}