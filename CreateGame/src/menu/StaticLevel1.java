package menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class StaticLevel1 {
	Rectangle test;
	
	/* ------------------------
	 * TEST LEVEL
	 * ------------------------
	 */
	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		test = new Rectangle(50, 50, 100, 100);
		g.draw(test);;
	}
}
