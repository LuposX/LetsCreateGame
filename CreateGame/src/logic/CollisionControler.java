package logic;

import java.util.ArrayList;

import entities.Entity;

public class CollisionControler {
	public static void detectEntityCollisions(ArrayList<Entity> entities) {
		//Fuer alle Entities (auﬂer das letzte)
		for(int i = 0; i < entities.size() - 1; i++) {
			Entity e1 = entities.get(i);
			
			//Fuer alle Entities mit einem Index groeﬂer als i
			for(int k = i + 1; k < entities.size(); k++) {
				Entity e2 = entities.get(k);
				if(e1.shape != null && e2.shape != null) {
					if(e1.shape.intersects(e2.shape)) {
						e1.onCollision(e2);
						e2.onCollision(e1);
					}
				}
			}
		}
	}
}
