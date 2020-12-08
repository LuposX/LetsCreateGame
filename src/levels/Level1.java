package levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import logic.Camera;
import logic.Controls;

public class Level1 extends BasicGameState{
	
	/* Test level
	 * -------------------
	 * This is a test level, used for testing stuff. Test level will be replaced
	 * later by a "real" level.
	 * 
	 */
	
	public Level1(int Level1) {}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		Controls.map = new TiledMap("res/level2/30tiles_by60tiles_map.tmx"); // Loading the level from a tilemap
		Controls.init(gc, sbg); // For documentation Check "Controls" class		
	}

	@Override
	// Hier kommt alles was mit grafik zu tun hat rein
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Camera.translate(gc, sbg, g);
		Controls.map.render(0, 0);
		Controls.render(gc, g);	
	}

	@Override
	// Hier kommt game-logic des levels rein
	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {	
		Controls.update(gc, sbg, t);
	}

	
	@Override
	public int getID() {
		return 3;
	}

}
