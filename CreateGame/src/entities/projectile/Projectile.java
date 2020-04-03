package entities.projectile;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;

public abstract class Projectile extends Entity{
	
	public float velocityX;
	public float velocityY;
	public Entity owner;
	
	public Projectile(float x, float y, float velX, float velY, Entity own) {
		super(x, y);
		velocityX = velX;
		velocityY = velY;
		owner = own;
	}

}
