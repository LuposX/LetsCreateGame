package levels;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import logic.Controls;

public class Level1 extends BasicGameState{
	Rectangle test;
	
	/* ------------------------
	 * TEST LEVEL
	 * ------------------------
	 */
	
	public Level1(int Level1) {
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		Controls.init(gc, sbg);
		
		test = new Rectangle(50, 50, 100, 100);
	}

	@Override
	// Hier kommt alles was mit grafik zu tun hat rein
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Controls.render(gc, g);
		
		g.draw(test);;
	}

	@Override
	// Hier kommt game-logic des levels rein
	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {	
		Controls.update(gc, sbg, t);
	}

	@Override
	public int getID() {
		return 1;
	}

}
