package logic;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import entities.Entity;
import entities.ItemEntity;
import entities.hostile.Slime;
import entities.player.Player;
import items.passive.SpeedItem;
import items.weapons.ItemRevolver;
import items.weapons.ItemSnowball;
import main.Game;
import utils.GameIsOver;

public class Controls {
	
	public static final float tileSize = 32;
	
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	public static Player player = new Player(17, 10);
		
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
		entities.add(new ItemEntity(3, 3, new ItemTest()));
		entities.add(new ItemEntity(5, 3, new ItemTest()));
		entities.add(new ItemEntity(7, 3, new ItemTest()));
		entities.add(new ItemEntity(9, 3, new ItemTest()));
		entities.add(new ItemEntity(11, 3, new ItemTest()));
		entities.add(new ItemEntity(13, 3, new ItemTest()));
		entities.add(new ItemEntity(15, 3, new ItemTest()));
		entities.add(new ItemEntity(17, 3, new ItemTest()));
		entities.add(new ItemEntity(19, 3, new ItemTest()));
		entities.add(new ItemEntity(21, 3, new ItemTest()));
		entities.add(new ItemEntity(28, 5, new ItemSnowball()));
		entities.add(new ItemEntity(19, 8, new ItemRevolver()));
	}
	
	public static void render(GameContainer gc, Graphics g) {		
		//Aufrufen aller Entities
		for(Entity en : entities) {
			en.prepareDraw();
			en.render(gc, g);
		}
		
		//Zeichnen von GUIs
		Camera.antiTranslate(gc, g);
		player.inventory.render(gc, g);
		player.render_health(gc, g); // used to render the halth from the player
		
		// Does graphics when game is over
		if(Game.gameIsOver) {
			GameIsOver.renderGameOver(gc, g);
		}
	}
	
	public static void update(GameContainer gc, StateBasedGame sbg, int dt) {
		if(Game.gameIsOver) {
			GameIsOver.updateGameOver(gc, sbg, dt);
		}
		
		//Aufrufen aller Entities
		for(int i = 0; i < entities.size(); i++) {
			Entity en = entities.get(i);
			en.prepare_speed(dt);
			en.update(gc, sbg, dt);
			
			if(en.wantToDie) {entities.remove(i);} //Entity wird aus der Liste entfernt
		}
		
		//Aufrufen des CollisionControlers
		CollisionControler.detectEntityCollisions(entities, dt);
		
		//Aufrufen der Kamera
		Camera.followEntity(player, gc);

	}
}
