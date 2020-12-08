package menus;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.Game;


public class Settings extends BasicGameState{
	public static String ON = "off";
	
	public Settings(int settings) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Keyboard/Mouse", 300, 100);
		g.drawString("Walk Left: A", 300, 150);
		g.drawString("Walk Right: D", 300, 170);
		g.drawString("Open Inventory: E", 300, 190);
		g.drawString("Sprint: SHIFT", 300, 210);
		g.drawString("Back", 30, 430);
		g.drawString("License: MIT", 780, 450);
		g.drawString("Game Settings", 300, 260);
		g.drawString("Developer Modus: " + ON, 300, 300);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
					
		//Back button
		if((posX > 25 && posX < 70) && (posY > 30 && posY < 55)){
			//System.out.println("drauf");
			if(Mouse.isButtonDown(0)){
				sbg.enterState(Game.START_MENU);
			}
		}
	} 

	public int getID() {
		return 4;
	}	
}
