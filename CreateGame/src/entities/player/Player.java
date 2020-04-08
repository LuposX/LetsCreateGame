package entities.player;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import entities.projectile.special.ProjectileSnowball;
import items.special.ItemTest;
import javafx.geometry.Rectangle2D;
import logic.CollisionControler;
import logic.Controls;
import net.java.games.input.Component.Identifier.Key;

public class Player extends Entity{	
	public Inventory inventory;
	
	public Player(float x, float y) {
		super(x, y);
		speed = 5;
		inventory = new Inventory(this); // Create a Inventory for the player and give it the player instanz
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
		
		if(pressedDirections > 1) {
			axisSpeed /= Math.sqrt(2);
		}
		
		if(gc.getInput().isKeyDown(Input.KEY_W)) {
			posY -= axisSpeed;
			hitbox = new Rectangle(posX-10f/32, posY-10f/32, 20f/32, 20f/32);
			if(CollisionControler.touchesTileLayer(hitbox, Controls.LAYER_WALL)) {posY += axisSpeed;}
		}
		if(gc.getInput().isKeyDown(Input.KEY_A)) {
			posX -= axisSpeed;
			hitbox = new Rectangle(posX-10f/32, posY-10f/32, 20f/32, 20f/32);
			if(CollisionControler.touchesTileLayer(hitbox, Controls.LAYER_WALL)) {posX += axisSpeed;}
		}
		if(gc.getInput().isKeyDown(Input.KEY_S)) {
			posY += axisSpeed;
			hitbox = new Rectangle(posX-10f/32, posY-10f/32, 20f/32, 20f/32);
			if(CollisionControler.touchesTileLayer(hitbox, Controls.LAYER_WALL)) {posY -= axisSpeed;}
		}
		if(gc.getInput().isKeyDown(Input.KEY_D)) {
			posX += axisSpeed;
			hitbox = new Rectangle(posX-10f/32, posY-10f/32, 20f/32, 20f/32);
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
					inventory.inventory[1].cooldownAktuell = inventory.inventory[1].cooldownSecundary;
				}
			}
		}
		
		//Updating hitbox
		hitbox = new Rectangle(posX-10f/32, posY-10f/32, 20f/32, 20f/32);
		
		//on passive
		for(int i = 0; i < inventory.inventory.length; i++) {
			if (inventory.inventory[i] != null) {
				if (inventory.inventory[i].hasPassive) {
					if (inventory.inventory[i].cooldownAktuell <= 0) {
						 inventory.inventory[i].onPassive();
						 inventory.inventory[i].cooldownAktuell =  inventory.inventory[i].cooldownPrimary;
					}
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
	public void render(GameContainer gc, Graphics g) {
		g.setColor(Color.red);
		
		shape = new Rectangle(drawX-10, drawY-10, 20, 20);
		g.fill(shape);
	}
}
