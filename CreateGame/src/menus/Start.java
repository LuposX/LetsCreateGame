package menus;

import java.util.concurrent.TimeUnit;

import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.Game;

public class Start extends BasicGameState{
	
	/* Start Menu
	 * ----------
	 *  This State is the Main Menu on the screen. You see this state first when you open
	 *  the Menu.
	 *  
	 *  //TODO: Change graphics and make it prettier. I am thinking of running a video in the bg of the Menu.
	 */
	
	public Start(int startmenu) {}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Here we render different string for the Main Menu
		g.setColor(Color.white);
		g.drawString("Play", 450, 170);
		g.drawString("Settings", 450, 220);
		g.drawString("Credits", 450, 270);
		g.drawString("Exit", 450, 320);
		g.drawString("Version: Alpha", 10, 450);
		g.drawString("License: MIT", 780, 450);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		// Getting the current Mouse position
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//Play button
		// Check if the mouse presses the button
		if((posX > 445 && posX < 490) && (posY > 290 && posY < 310)){
			if(Mouse.isButtonDown(0)){
				try {
					TimeUnit.MILLISECONDS.sleep(100); // If we dont have that here. It will instantly jump in the first level
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sbg.enterState(Game.LEVEL_MENU);
			}
		}
		
		//Settings button
		if((posX > 445 && posX < 520) && (posY > 240 && posY < 260)){
			if(Mouse.isButtonDown(0)){
				//sbg.enterState(4); 
				throw new java.lang.UnsupportedOperationException("Not supported yet.");
				}
			}
		
		//Exit button
		if((posX > 430 && posX < 510) && (posY > 140 && posY < 160)){
			if(Mouse.isButtonDown(0)){
				AL.destroy();
				System.exit(0);
				}
		}
		
		//Credits Button
		if((posX > 445 && posX < 520) && (posY > 190 && posY < 210)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(Game.CREDITS_MENU);
			}
		}
	}

	public int getID() {
		return 0;
	}	
}
