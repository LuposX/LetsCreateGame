package entities.projectile;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;

public class ProjectileSnowball extends Projectile {

	public float speed = 5;
	
	public ProjectileSnowball(float x, float y, float velX, float velY, Entity own) {
		super(x, y, velX, velY, own);
		age = 0;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int t) {
		posX += directionX*speed;
		posY += directionY*speed;
		age++;
		//Todesbedingung
		if(age > 100) {
			wantToDie = true;
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		shape = new Rectangle(posX-2,posY-2,4,4);
		
		g.setColor(Color.white);
		g.fill(shape);
	}

}
