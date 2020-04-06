package entities.hostile;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Slime extends Hostile{

	public Slime(float x, float y) {
		super(x, y);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		shape = new Rectangle(drawX-10, drawY-10, 20, 20);
		g.setColor(Color.green);
		g.fill(shape);
	}
	
}
