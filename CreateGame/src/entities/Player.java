package entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import entities.projectile.ProjectileSnowball;
import javafx.geometry.Rectangle2D;
import logic.Controls;
import net.java.games.input.Component.Identifier.Key;

public class Player extends Entity{
	
	public float speed = 0.08f;
	public float aktspeed = speed;
	
	public int cooldownPrimary = 0; //Cooldown f�r den Standartangriff | <= 0 hei�t ready
	public int cooldownPrimaryMax = 10;
	
	public Player(float x, float y) {
		super(x, y);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		//Input-Control
		System.out.println(""+dt);
		if(gc.getInput().isKeyDown(Input.KEY_W) || gc.getInput().isControllerUp(gc.getInput().ANY_CONTROLLER)) {
			posY -= aktspeed;
		}
		if(gc.getInput().isKeyDown(Input.KEY_A) || gc.getInput().isControllerLeft(gc.getInput().ANY_CONTROLLER)) {
			posX -= aktspeed;
		}
		if(gc.getInput().isKeyDown(Input.KEY_S) || gc.getInput().isControllerDown(gc.getInput().ANY_CONTROLLER)) {
			posY += aktspeed;
		}
		if(gc.getInput().isKeyDown(Input.KEY_D) || gc.getInput().isControllerRight(gc.getInput().ANY_CONTROLLER)) {
			posX += aktspeed;
		}
		
		if(gc.getInput().isMouseButtonDown(0)) {
			if(cooldownPrimary <= 0) {
				Controls.entities.add(new ProjectileSnowball(posX, posY, gc.getInput().getMouseX()/Controls.tileSize, gc.getInput().getMouseY()/Controls.tileSize, this));
				cooldownPrimary = cooldownPrimaryMax;
			} else {
				cooldownPrimary--;
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		g.setColor(Color.red);
		
		shape = new Rectangle(drawX-7, drawY-7, 14, 14);
		g.fill(shape);
	}

}
