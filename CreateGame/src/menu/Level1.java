package menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Level1 extends BasicGameState{
	StaticLevel1 level;
	
	/* ------------------------
	 * TEST LEVEL
	 * ------------------------
	 */
	
	public Level1(int Level1) {
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		level = new StaticLevel1();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Hier kommt alles was mit grafik zu tun hat rein
		level.render(gc, g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int arg2) throws SlickException {	
		// Hier kommt game-logic des levels rein
	}

	@Override
	public int getID() {
		return 1;
	}

}
