package logic;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import entities.Player;

public class Controls {
	
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	public static Player player = new Player(100, 100);
	
	public static void init(GameContainer gc, StateBasedGame sbg) {
		entities.add(player);
	}
	
	public static void render(GameContainer gc, Graphics g) {
		
		//Aufrufen aller Entities
		for(Entity en : entities) {
			en.render(gc, g);
		}
	}
	
	public static void update(GameContainer gc, StateBasedGame sbg, int t) {
		//Aufrufen aller Entities
		for(Entity en : entities) {
			en.update(gc, sbg, t);
		}
	}
}
