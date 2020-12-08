package logic;

import java.util.ArrayList;

import org.newdawn.slick.geom.Shape;

import entities.Entity;

public class CollisionControler {
	/**
	 * Diese Methode ruft alle Objekte auf, die eine Kollision haben
	 * @param entities Die Liste aller Objekte extending Entity
	 * @return void
	 */
	public static void detectEntityCollisions(ArrayList<Entity> entities) {
		//Fuer alle Entities (auﬂer das letzte)
		for(int i = 0; i < entities.size() - 1; i++) {
			Entity e1 = entities.get(i);
			
			//Fuer alle Entities mit einem Index groeﬂer als i
			for(int k = i + 1; k < entities.size(); k++) {
				Entity e2 = entities.get(k);
				if(e1.hitbox != null && e2.hitbox != null) {
					if(e1.hitbox.intersects(e2.hitbox)) {
						e1.onCollision(e2);
						e2.onCollision(e1);
					}
				}
			}
		}
	}
	/**
	 * Diese Methode ueberprueft ob eine Hitbox eine Layer beruehrt
	 * @param hitbox Die Hitbox, layer Die ID der Layer
	 * @return true, wenn sie sich beruehren
	 */
	public static boolean touchesTileLayer(Shape hitbox, int layer) {
		for(int i = 0; i < hitbox.getPointCount(); i++) {
			float[] pos = hitbox.getPoint(i);
			float posX = pos[0];
			float posY = pos[1];
			
			if(Controls.map.getHeight() <= posY || Controls.map.getWidth() <= posX || posX < 0 || posY < 0) {
				return true;
			}
			
			if(0 != Controls.map.getTileId((int) posX, (int) posY, layer)){
				return true;
			}
		}
		
		return false;
	}
	/**
	 * Diese Methode ueberprueft ob eine Koordinate eine Layer beruehrt
	 * @param posX Die X-Koordinate,posY Die Y-Koordinate, layer Die ID der Layer
	 * @return true, wenn sie sich beruehren
	 */
	public static boolean isCordInLayer(float posX, float posY, int layer) {
		
		if(Controls.map.getHeight() <= posY || Controls.map.getWidth() <= posX || posX < 0 || posY < 0) {
			return true;
		}
		if(0 != Controls.map.getTileId((int) posX, (int) posY, layer)){
			return true;
		}
		
		return false;
	}
}
