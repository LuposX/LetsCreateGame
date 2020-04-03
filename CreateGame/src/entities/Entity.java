package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Entity {
	float posX;
	float posY;
	Shape shape;
	
	public Entity(float x, float y){
		posX = x;
		posY = y;
	}
	
	public abstract void update(GameContainer gc, StateBasedGame sbg, int t); //Dient zum Updaten von Physik und Logik
	public abstract void render(GameContainer gc, Graphics g); //Dient zum Zeichnen der Graphik
	
}
