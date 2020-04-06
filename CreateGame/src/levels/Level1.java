package levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import logic.Controls;

public class Level1 extends BasicGameState{
	
	/* ------------------------
	 * TEST LEVEL
	 * ------------------------
	 * FAG YOU
	 */
	private TiledMap map;
	
	public Level1(int Level1) {
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		Controls.init(gc, sbg);
		
		map = new TiledMap("res/level1.tmx"); // loading the level from a tilemap
	}

	@Override
	// Hier kommt alles was mit grafik zu tun hat rein
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.render(0, 0);
		Controls.render(gc, g);	
	}

	@Override
	// Hier kommt game-logic des levels rein
	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {	
		Controls.update(gc, sbg, t);
	}

	@Override
	public int getID() {
		return 2;
	}

}
