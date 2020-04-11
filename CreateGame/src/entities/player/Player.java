package entities.player;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import entities.Entity;
import entities.hostile.Hostile;
import entities.projectile.special.ProjectileSnowball;
import items.special.ItemTest;
import javafx.geometry.Rectangle2D;
import logic.CollisionControler;
import logic.Controls;
import main.Game;
import net.java.games.input.Component.Identifier.Key;

import org.newdawn.slick.Font;

public class Player extends Entity{	
	public Inventory inventory;
	public int cooldownOnCollision = 100;
	public int cooldownOnCollisionAktuell = cooldownOnCollision + 1;
	
	public Player(float x, float y) {
		super(x, y);
		speed = 5;
		health = 5f;
		inventory = new Inventory(this); // Create a Inventory for the player and give it the player instanz
		
		try {
			image = new Image("res/textures/player/knight_f_hit_anim_f0_upscale.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void render_health(GameContainer gc, Graphics g) {
		/* Draw the health on the display for the player
		 * 
		 */	
		g.setColor(Color.red);
		g.drawString("Player Health: ", 10, 40);
		
		for(int i = 0; i < health; i++) {
			float x = (10+(i % 5)*30);
			float y = (60+(int)(i / 6)*70);
			Rectangle healthBG = new Rectangle(x, y, 15, 15);
			
			g.fill(healthBG);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		//Update Inventory
		inventory.update(gc, sbg, dt);
		
		float axisSpeed = aktuellerSpeed; //Die Geschwindigkeit in X bzw. Y Richtung
		int pressedDirections = 0;
		if(gc.getInput().isKeyDown(Input.KEY_W)) {pressedDirections++;}
		if(gc.getInput().isKeyDown(Input.KEY_A)) {pressedDirections++;}
		if(gc.getInput().isKeyDown(Input.KEY_S)) {pressedDirections++;}
		if(gc.getInput().isKeyDown(Input.KEY_D)) {pressedDirections++;}
		
		if (health <= 0) {
			Game.gameIsOver = true;
		}
		
		if(pressedDirections > 1) {
			axisSpeed /= Math.sqrt(2);
		}
		
		if(gc.getInput().isKeyDown(Input.KEY_W)) {
			posY -= axisSpeed;
			updateHitbox();
			if(CollisionControler.touchesTileLayer(hitbox, Controls.LAYER_WALL)) {posY += axisSpeed;}
		}
		if(gc.getInput().isKeyDown(Input.KEY_A)) {
			posX -= axisSpeed;
			updateHitbox();
			if(CollisionControler.touchesTileLayer(hitbox, Controls.LAYER_WALL)) {posX += axisSpeed;}
		}
		if(gc.getInput().isKeyDown(Input.KEY_S)) {
			posY += axisSpeed;
			updateHitbox();
			if(CollisionControler.touchesTileLayer(hitbox, Controls.LAYER_WALL)) {posY -= axisSpeed;}
		}
		if(gc.getInput().isKeyDown(Input.KEY_D)) {
			posX += axisSpeed;
			updateHitbox();
			if(CollisionControler.touchesTileLayer(hitbox, Controls.LAYER_WALL)) {posX -= axisSpeed;}
		}
		
		if(gc.getInput().isMouseButtonDown(0)) {
			if(inventory.inventory.length > 0 && inventory.inventory[0] != null) {
				if (inventory.inventory[0].cooldownAktuell <= 0) {
					inventory.inventory[0].cooldownAktuell = inventory.inventory[0].cooldownPrimary;
					inventory.inventory[0].onActive(gc, sbg, dt);
				}
			}
		}
		
		if(gc.getInput().isMouseButtonDown(1)) {
			if(inventory.inventory.length > 1 && inventory.inventory[1] != null) {
				if (inventory.inventory[1].cooldownAktuell <= 0) {
					inventory.inventory[1].onActive(gc, sbg, dt);
					inventory.inventory[1].cooldownAktuell = inventory.inventory[1].cooldownPrimary;
				}
			}
		}
			
		// Update cooldown for every item in inventory
		for(int i = 0; i < inventory.inventory.length; i++) {
			if (inventory.inventory[i] != null) {
				 inventory.inventory[i].cooldownAktuell -= dt;
			}
		}
	}
	
	@Override
	public void onCollision(Entity en, int dt) {
		if (en instanceof Hostile) {
			if (cooldownOnCollisionAktuell >= cooldownOnCollision) {
				health = damage(health);
				cooldownOnCollisionAktuell = 0;
			} else {
				cooldownOnCollisionAktuell += dt;
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		g.setColor(Color.red);
		
		g.drawImage(image, drawX - 10, drawY - 10); 
	}

	@Override
	public void updateHitbox() {
		hitbox = new Rectangle(posX-10f/32, posY-10f/32, 20f/32, 20f/32);
	}
}
