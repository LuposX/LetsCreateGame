package logic;

import java.util.ArrayList;

import org.newdawn.slick.geom.Shape;

import entities.Entity;

public class CollisionControler {
	//Input: Liste der Entities
	//Diese Methode ruft alle Objekte auf, die eine Kollision haben
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
	//Input: Zu ueberpruefendes Shape und Layer (Alles bezieht sich auf die Tilemap map)
	//Ueberprueft ob sich die Layer und das Objekt an einem Vertex beruehren
	//Output: true <- beruehrt; false <- nicht beruehrt
	public static boolean touchesTileLayer(Shape hitbox, int layer) {
		for(int i = 0; i < hitbox.getPointCount(); i++) {
			float[] pos = hitbox.getPoint(i);
			float posX = pos[0];
			float posY = pos[1];
			
			System.out.println(posX + ";" + posY + ";" + layer);
			if(0 != Controls.map.getTileId((int) posX, (int) posY, layer)){
				return true;
			}
		}
		
		return false;
	}
}
