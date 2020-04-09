package logic;

import entities.Entity;

public class PathFinder {
	public static boolean isEyeContact(Entity e1, Entity e2) {
		/** Is searching a Eye-Contact between the Entities
		 * @param e1 the first Entity, e2 the second ENtity
		 * @return boolean true if there is a eye-contact
		 **/
		
		return isEyeContact(e1.posX, e1.posY, e2.posX, e2.posY);
	}
	
	public static boolean isEyeContact(float x1, float y1, float x2, float y2) {
		/** Is searching a Eye-Contact between the Cordinates
		 * @param x1, y1, x2, y2 are the cordinates
		 * @return boolean true if there is a eye-contact
		 **/
		
		int checks = (int) (5 * Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
		
		for(int i = 0; i < checks; i++) {
			int cx = (int) (x1+((x2-x1)/checks)*i);			
			int cy = (int) (y1+((y2-y1)/checks)*i);	
			
			if(Controls.map.getTileId(cx, cy, Controls.LAYER_WALL) != 0) {
				return false;
			}
		}
		
		return true;
	}
}
