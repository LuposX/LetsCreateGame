package entities.projectile.special;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import entities.projectile.Projectile;
import sun.awt.windows.WWindowPeer;

public class ProjectileSnowball extends Projectile {

	
	public ProjectileSnowball(float x, float y, float velX, float velY, Entity own) {
		super(x, y, velX, velY, own);
		age = 0;
		speed = 10;
		remainingWallHits = 0; // Scnee prallt nicht ab
		wallHitSpeedLoss = 0.5f;
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
		updateHitbox();
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		shape = new Rectangle(drawX-2,drawY-2,4,4);
		
		g.setColor(Color.white);
		g.fill(shape);
	}
	
	//Collisionstest mit Schneeball
	@Override
	public void onCollision(Entity en, int dt) {
		if(en != owner) {
			this.wantToDie = true;
		}
	}

	@Override
	public void updateHitbox() {
		hitbox = new Rectangle(posX-2f/32, posY-2f/32, 4f/32, 4f/32);
	}

}
