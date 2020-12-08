package logic;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;

public class Camera {
	public static float cameraX = 0;
	public static float cameraY = 0;
	
	
	
	public static void translate(GameContainer gc, StateBasedGame sbg, Graphics g) {
		/**Verschiebt das Bild in die Richtige kamera-Position
		**/
		cameraY += 0.1;
		g.translate(-cameraX, -cameraY);
	}
	
	public static void antiTranslate(GameContainer gc, Graphics g) {
		/**Kehrt translate() um.
		**/
		g.translate(cameraX, cameraY);
	}
	
	public static void followEntity(Entity e, GameContainer gc) {
		/**Die Kamera folgt dem Entity
		 * @param e das Entity
		**/
		cameraX = e.drawX-gc.getWidth()/2f;
		cameraY = e.drawY-gc.getHeight()/2f;
		
		cameraX = Math.max(cameraX, 0);
		cameraY = Math.max(cameraY, 0);
		cameraX = Math.min(cameraX, Controls.map.getWidth()*Controls.tileSize-gc.getWidth());
		cameraY = Math.min(cameraY, Controls.map.getHeight()*Controls.tileSize-gc.getHeight());
	}
	
	public static float getMouseX(Input inp) {
		/**Die folgenden zwei Methoden geben die Koordinate der Maus zurück, nur das sie mit der kamera verschoben ist
		 * @param inp der Input
		 * @return die veraenderte X-Koordinate
		**/
		return inp.getMouseX()+cameraX;
	}
	
	public static float getMouseY(Input inp) {
		/**Die folgenden Methode gibt die Koordinate der Maus zurück, nur das sie mit der kamera verschoben ist
		 * @param inp der Input
		 * @return die veraenderte Y-Koordinate
		**/
		return inp.getMouseY()+cameraY;
	}
}
