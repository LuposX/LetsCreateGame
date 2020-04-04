package entities.projectile;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;

public abstract class Projectile extends Entity{
	
	public float directionX; //directionX^2 + directionY^2 = 1
	public float directionY;
	public Entity owner;
	
	//targX und tagrY sind die Koordinaten auf die der Schuss zu Beginn ziehlt
	public Projectile(float x, float y, float targX, float targY, Entity own) {
		super(x, y);
		
		//Berechnung der Richtung des Projectiles
		float dX = (targX-posX);
		float dY = (targY-posY);
		float dXY = (float) Math.sqrt(dX*dX+dY*dY);
		
		directionX = dX/dXY;
		directionY = dY/dXY;
		
		owner = own;
	}

}
