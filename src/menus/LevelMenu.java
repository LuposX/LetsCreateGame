package menus;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.Game;

public class LevelMenu extends BasicGameState {
	
	/* Level Menu
	 * ----------
	 *  This State is the Level Menu. Here can you select different levels you want to play
	 *  
	 *  Options:
	 *  "Play the Game" Play the first real level. Doesn't exist yet 
	 *  "Playground" A map where you can test different items on enemies.
	 *  
	 *  Maybe Future options:
	 *  "Endless Mode" Defend yourself endless.
	 */
	
	public LevelMenu(int levelmenu) {}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Here we render different string for the Main Menu
		g.setColor(Color.white);
		g.drawString("Play the Game", 450, 170);
		g.drawString("Playground", 450, 220);
		g.drawString("License: MIT", 780, 450);
		g.drawString("Back", 30, 430);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int dt) throws SlickException {
		// Getting the current Mouse position
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		// Check if the mouse presses the button
		if((posX > 445 && posX < 490) && (posY > 290 && posY < 310)){
			if(Mouse.isButtonDown(0)){
				//TODO: implement real level "here"
				throw new java.lang.UnsupportedOperationException("Not supported yet. We're missing a level.");
			}
		}
		
		if((posX > 445 && posX < 520) && (posY > 240 && posY < 260)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(Game.START_LEVEL);
				}
			}
		
		//Back button
		if((posX > 25 && posX < 70) && (posY > 30 && posY < 55)){
			//System.out.println("drauf");
			if(Mouse.isButtonDown(0)){
				sbg.enterState(Game.START_MENU);
			}
		}
	}

	@Override
	public int getID() {
		return 2;
	}

}
