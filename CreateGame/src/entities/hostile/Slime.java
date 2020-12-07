package entities.hostile;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import logic.Controls;
import logic.PathFinder;

public class Slime extends Hostile{

	public Slime(float x, float y) {
		super(x, y);
		speed = 2;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		updateHitbox();
		
		if(PathFinder.isEyeContact(this, target)){
			runTo(target.posX, target.posY);
			agro += dt;
			agro = Math.max(agro, 3000);
		} else if(agro > 0) {
			agro -= dt/4;
			ArrayList<int[]> path = PathFinder.findPath((int) posX, (int) posY, (int) target.posX, (int) target.posY);
			if(path.size() > 1) {
				runTo(path.get(path.size()-2)[0]+0.5f, path.get(path.size()-2)[1]+0.5f);
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		shape = new Rectangle(drawX-10, drawY-10, 20, 20);
		g.setColor(Color.green);
		g.fill(shape);
	}

	@Override
	public void updateHitbox() {
		hitbox = new Rectangle(posX-10f/32, posY-10f/32, 20f/32, 20f/32);
	}
	
}
