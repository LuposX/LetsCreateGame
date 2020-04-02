package menu;

import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Ingame extends BasicGameState{
	
	public Ingame(int startmenu) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.green);
		g.setColor(Color.white);
	}


	public int getID() {
		return 1;
	}	
}
