package utils;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class GameIsOver {
	static java.awt.Font awtFont = new java.awt.Font("Verdana", java.awt.Font.BOLD, 28);
	static Font gameIsOverFont = new TrueTypeFont(awtFont, false);
	
	public static void renderGameOver(GameContainer gc, Graphics g) {
		/* Gets executed when gameisover.
		 * 
		 */
		gameIsOverFont.drawString(gc.getWidth() / 2, gc.getHeight() / 2, "Game Over", Color.red);
	}
	
	public static void updateGameOver(GameContainer gc, StateBasedGame sbg, int dt) {
		
	}
}
