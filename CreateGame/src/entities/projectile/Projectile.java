package entities.projectile;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import logic.CollisionControler;
import logic.Controls;

public abstract class Projectile extends Entity{
	
	public float directionX; //directionX^2 + directionY^2 = 1
	public float directionY;
	public Entity owner;
	
	public float wallHitSpeedLoss = 0f; //Geschwindigkeitsverlust bei Wandtreffer 0.3 = 30%
	public int remainingWallHits = 1; //Anzahl der moeglichen Wandtreffer
	
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
	
	public abstract void updateProjectile(GameContainer gc, StateBasedGame sbg, int dt);
	
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		updateProjectile(gc, sbg, dt);
		testWallCollision();
	}
	
	/**
	 * Ueberprueft, ob das Projektil die Wand getroffen hat und handelt dem entsprechend
	 * @return void
	 */
	public void testWallCollision() {
		if(CollisionControler.isCordInLayer(posX, posY, Controls.LAYER_WALL)) {
			if(remainingWallHits > 0) {
				speed *= (1-wallHitSpeedLoss);
				remainingWallHits--;
				
				if(directionX > 0 && !CollisionControler.isCordInLayer(posX-aktuellerSpeed, posY, Controls.LAYER_WALL)) {
					directionX *= -1;
				}
				else if(directionX < 0 && !CollisionControler.isCordInLayer(posX+aktuellerSpeed, posY, Controls.LAYER_WALL)) {
					directionX *= -1;
				}
				else if(directionY < 0 && !CollisionControler.isCordInLayer(posX, posY+aktuellerSpeed, Controls.LAYER_WALL)) {
					directionY *= -1;
				}
				else if(directionY > 0 && !CollisionControler.isCordInLayer(posX, posY-aktuellerSpeed, Controls.LAYER_WALL)) {
					directionY *= -1;
				} else {
					directionX *= -1;
					directionY *= -1;
				}
				
			} else {
				wantToDie = true;
			}
			wallHitSpecialReaction();
		}
	}
	
	/**
	 * Wird nach testWallCollision ausgefuehrt. Soll von Unterklassen implementiert werden.
	 * @return void
	 */
	public void wallHitSpecialReaction() {
		
	}
}
