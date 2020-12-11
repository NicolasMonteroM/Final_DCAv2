package view;

import java.util.ArrayList;

import controller.Controller;
import exceptions.NotANicknameException;
import exceptions.UnvalidNickname;
import processing.core.PApplet;
import processing.core.PFont;

public class Main extends PApplet{

	PFont font;
	private Register register;
	private Leaderboard leaderboard;
	private Controller controller;

	private String screen;
	private Personaje personaje;
	private ArrayList<Platform> plataformas;
	private ArrayList<Platform> plataformas2;
	private ArrayList<Platform> plataformas1;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(768, 458);
		
	}

	public void setup() {
		
		controller = new Controller(this);
		
		screen = "level 1";
		font = createFont("Anonymous Pro Bold", 12);
		register = new Register(this);
		leaderboard = new Leaderboard(this);
		
		controller.createGame();

		plataformas=new ArrayList<Platform>();
		plataformas2=new ArrayList<Platform>();
		plataformas1=new ArrayList<Platform>();
		
		// lvl 1
		
		plataformas1.add(new Platform(1,408,282,this));
		plataformas1.add(new Platform(301,353,92,this));
		plataformas1.add(new Platform(469,273,148,this));
		plataformas1.add(new Platform(469,352,251,this));
		
		
		//lvl 2
		
		plataformas2.add(new Platform(1,408,282,this));
		plataformas2.add(new Platform(360,407,179,this));
		plataformas2.add(new Platform(648,407,120,this));
		plataformas2.add(new Platform(132,354,95,this));
		plataformas2.add(new Platform(551,354,95,this));
		plataformas2.add(new Platform(504,320,35,this));
		plataformas2.add(new Platform(289,312,40,this));
		plataformas2.add(new Platform(0,312,82,this));
		plataformas2.add(new Platform(352,269,82,this));
		plataformas2.add(new Platform(132,269,110,this));
		plataformas2.add(new Platform(2,227,82,this));
		plataformas2.add(new Platform(289,193,40,this));
		plataformas2.add(new Platform(211,193,40,this));
		plataformas2.add(new Platform(132,193,40,this));
		plataformas2.add(new Platform(2,152,82,this));
		plataformas2.add(new Platform(370,152,40,this));
		plataformas2.add(new Platform(445,110,40,this));
		plataformas2.add(new Platform(566,152,179,this));
		
		
		//lvl 3
		
		plataformas.add(new Platform(1,408,282,this));
		plataformas.add(new Platform(485,408,282,this));
		plataformas.add(new Platform(241,362,75,this));
		plataformas.add(new Platform(460,362,75,this));
		plataformas.add(new Platform(352,330,42,this));
		plataformas.add(new Platform(127,316,75,this));
		plataformas.add(new Platform(43,283,42,this));
		plataformas.add(new Platform(552,299,42,this));
		plataformas.add(new Platform(652,269,42,this));
		plataformas.add(new Platform(385,253,42,this));
		plataformas.add(new Platform(268,212,75,this));
		plataformas.add(new Platform(127,223,75,this));
		plataformas.add(new Platform(10,154,42,this));
		plataformas.add(new Platform(482,212,42,this));
		plataformas.add(new Platform(582,227,42,this));
		plataformas.add(new Platform(708,222,42,this));
		plataformas.add(new Platform(367,136,117,this));
		plataformas.add(new Platform(582,125,186,this));
		
		
		colorMode(HSB, 360, 360, 360);
		personaje= new Personaje(this,43,376);

	}

	public void draw() {
		background(0);
		textFont(font);
	
		personaje.choque= false;

		// Screens
		//System.out.println(screen);  
		
		
		
		switch (screen) { 

		case "register":
			register.drawScreen();
			screen = register.changeScreen();
			fill(240);
			text("LEADERBOARD", 350, 385);
			leaderboard.getCp5().hide();
			register.getCp5().show();


			break;

		case "level 1":
			register.getCp5().hide();
			background(0);
			for(Platform i: plataformas1) {
				i.show();
				if(i.collide(personaje.posPersonaje)) {
					personaje.choque=true;
					personaje.posPersonaje.y=i.pos.y;
				}
			}
			personaje.pintar();
			controller.drawGame();
			break;
			
		case "level 2":
			background(0);
			for(Platform i: plataformas2) {
				i.show();
				if(i.collide(personaje.posPersonaje)) {
					personaje.choque=true;
					personaje.posPersonaje.y=i.pos.y;
				}
			}
			personaje.pintar();

			break;
			
		case "level 3":
			
			background(0);
			
			for(Platform i: plataformas) {
				i.show();
				if(i.collide(personaje.posPersonaje)) {
					personaje.choque=true;
					personaje.posPersonaje.y=i.pos.y;
				}
			}
			personaje.pintar();
			
			break;
			
		case "leaderboard":
			register.getCp5().hide();
			leaderboard.drawScreen();
			leaderboard.getCp5().show();
			screen = leaderboard.changeScreen();


			break;

		}

		// System.out.println(mouseX + " - " + mouseY); // Mouse position on console

	}

	public void keyPressed() {
		if(key=='a') {
			personaje.movimiento=-personaje.distancia;
			
		}
		if(key=='d' ) {
			personaje.movimiento=personaje.distancia;
			
		}
		if(key==' ' ) {
			if(personaje.choque) {
				personaje.vel.y -= 7;
				
			}
		}
			
	}
	public void keyReleased() {
		if(key=='a') {
			personaje.movimiento=0;
			
		}
		if(key=='d') {
			personaje.movimiento=0;
		}
	}

	public void mousePressed() {
		try {
			register.registerNewPlayer();
		} catch (UnvalidNickname e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotANicknameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
