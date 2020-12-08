package menus;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.Game;

import java.util.prefs.Preferences;


public class Settings extends BasicGameState{
	public static String DEVELOPER_MODE = "off";
	public static Preferences PREF = Preferences.userRoot().node("LetsCreateGameSettings");
	
	public Settings(int settings) {
		PREF.putBoolean("Developer_Mode", false);
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
		g.drawString("Developer Modus: " + DEVELOPER_MODE, 300, 300);
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
		
		//Enable Developer mode
		// Should do Stuff like show Hitboxes
		if((posX > 290 && posX < 490) && (posY > 160 && posY < 180)){
			//System.out.println("drauf");
			if(Mouse.isButtonDown(0)){
				if (PREF.getBoolean("Developer_Mode", true) == false) {
					DEVELOPER_MODE = "on";
					PREF.putBoolean("Developer_Mode", true);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					DEVELOPER_MODE = "off";
					PREF.putBoolean("Developer_Mode", false);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			System.out.println("Developer mode: " + DEVELOPER_MODE);
			}
		}
	} 

	public int getID() {
		return 4;
	}	
}
