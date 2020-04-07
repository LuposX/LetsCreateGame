package player;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import entities.projectile.ProjectileSnowball;
import javafx.geometry.Rectangle2D;
import logic.Controls;
import net.java.games.input.Component.Identifier.Key;

public class Player extends Entity{
	
	
	public int cooldownPrimary = 0; //Cooldown f�r den Standartangriff | <= 0 hei�t ready
	public int cooldownPrimaryMax = 10;
	
	public Player(float x, float y) {
		super(x, y);
		speed = 5;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		//Input-Control
		if(gc.getInput().isKeyDown(Input.KEY_W) || gc.getInput().isControllerUp(gc.getInput().ANY_CONTROLLER)) {
			posY -= aktuellerSpeed;
		}
		if(gc.getInput().isKeyDown(Input.KEY_A) || gc.getInput().isControllerLeft(gc.getInput().ANY_CONTROLLER)) {
			posX -= aktuellerSpeed;
		}
		if(gc.getInput().isKeyDown(Input.KEY_S) || gc.getInput().isControllerDown(gc.getInput().ANY_CONTROLLER)) {
			posY += aktuellerSpeed;
		}
		if(gc.getInput().isKeyDown(Input.KEY_D) || gc.getInput().isControllerRight(gc.getInput().ANY_CONTROLLER)) {
			posX += aktuellerSpeed;
		}
		
		
		if(gc.getInput().isMouseButtonDown(0)) {
			System.out.println("?");
			if(cooldownPrimary <= 0) {
				System.out.println("X");
				Controls.entities.add(new ProjectileSnowball(posX, posY, gc.getInput().getMouseX()/Controls.tileSize, gc.getInput().getMouseY()/Controls.tileSize, this));
				cooldownPrimary = cooldownPrimaryMax;
			}
		}
		cooldownPrimary--;
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		g.setColor(Color.red);
		
		shape = new Rectangle(drawX-10, drawY-10, 20, 20);
		g.fill(shape);
	}

}
