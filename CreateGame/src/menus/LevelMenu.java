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
	
	public LevelMenu(int levelmenu) {}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Here we render different string for the Main Menu
		g.setColor(Color.white);
		g.drawString("Play the Game", 450, 170);
		g.drawString("Playground", 450, 220);
		g.drawString("Version: Alpha", 10, 450);
		g.drawString("License: MIT", 780, 450);
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
				throw new java.lang.UnsupportedOperationException("Not supported yet.");
			}
		}
		
		if((posX > 445 && posX < 520) && (posY > 240 && posY < 260)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(Game.START_LEVEL);
				}
			}
	}

	@Override
	public int getID() {
		return 2;
	}

}
