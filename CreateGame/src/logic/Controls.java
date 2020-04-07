package logic;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import entities.Entity;
import entities.ItemEntity;
import entities.hostile.Slime;
import entities.player.Player;
import items.ItemTest;

public class Controls {
	
	public static final float tileSize = 32;
	
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	public static Player player = new Player(10, 10);
		
	public static TiledMap map;
	
	public static int LAYER_GROUND;
	public static int LAYER_WALL;
	
	public static void init(GameContainer gc, StateBasedGame sbg) {
		//belegen der "Halb-Konstanten"
		LAYER_GROUND = map.getLayerIndex("ground");
		LAYER_WALL = map.getLayerIndex("wall");
		
		
		entities.add(player);	
		
		//Testweises hinzufuegen von Entities
		entities.add(new Slime(14, 3));
		entities.add(new ItemEntity(2, 4, new ItemTest()));
		entities.add(new ItemEntity(2, 5, new ItemTest()));
		entities.add(new ItemEntity(2, 6, new ItemTest()));
		entities.add(new ItemEntity(2, 7, new ItemTest()));
		entities.add(new ItemEntity(2, 8, new ItemTest()));
		entities.add(new ItemEntity(2, 9, new ItemTest()));
		entities.add(new ItemEntity(2, 10, new ItemTest()));
		entities.add(new ItemEntity(2, 11, new ItemTest()));
		entities.add(new ItemEntity(2, 12, new ItemTest()));
	}
	
	public static void render(GameContainer gc, Graphics g) {
		
		//Aufrufen aller Entities
		for(Entity en : entities) {
			en.prepareDraw();
			en.render(gc, g);
		}
		
		//Zeichnen des Inventars
		player.inventory.render(gc, g);
	}
	
	public static void update(GameContainer gc, StateBasedGame sbg, int dt) {
		//Aufrufen aller Entities
		for(int i = 0; i < entities.size(); i++) {
			Entity en = entities.get(i);
			en.prepare_speed(dt);
			en.update(gc, sbg, dt);
			
			if(en.wantToDie) {entities.remove(i);} //Entity wird aus der Liste entfernt
		}
		
		//Aufrufen des CollisionControlers
		CollisionControler.detectEntityCollisions(entities);

	}
}
