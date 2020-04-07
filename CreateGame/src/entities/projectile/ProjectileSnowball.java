package entities.projectile;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;

public class ProjectileSnowball extends Projectile {

	
	public ProjectileSnowball(float x, float y, float velX, float velY, Entity own) {
		super(x, y, velX, velY, own);
		age = 0;
		speed = 13;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int t) {
		posX += directionX*aktuellerSpeed;
		posY += directionY*aktuellerSpeed;
		age++;
		//Todesbedingung
		if(age > 200) {
			wantToDie = true;
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		shape = new Rectangle(drawX-2,drawY-2,6,6);
		
		g.setColor(Color.magenta);
		g.fill(shape);
	}
	
	//Collisionstest mit Schneeball
	@Override
	public void onCollision(Entity en) {
		if(en != owner) {
			System.out.println("Treffer");
			this.wantToDie = true;
		}
	}

}
