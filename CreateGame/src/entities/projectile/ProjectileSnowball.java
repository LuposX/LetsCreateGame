package entities.projectile;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import sun.awt.windows.WWindowPeer;

public class ProjectileSnowball extends Projectile {

	
	public ProjectileSnowball(float x, float y, float velX, float velY, Entity own) {
		super(x, y, velX, velY, own);
		age = 0;
		speed = 13;
		remainingWallHits = 10;
		wallHitSpeedLoss = 0f;
	}

	@Override
	public void updateProjectile(GameContainer gc, StateBasedGame sbg, int t) {
		posX += directionX*aktuellerSpeed;
		posY += directionY*aktuellerSpeed;
		age++;
		//Todesbedingung
		if(age > 200) {
			wantToDie = true;
		}
		
		//Update hitbox
		hitbox = new Rectangle(posX-2f/32, posY-2f/32, 4f/32, 4f/32);
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		shape = new Rectangle(drawX-2,drawY-2,4,4);
		
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
