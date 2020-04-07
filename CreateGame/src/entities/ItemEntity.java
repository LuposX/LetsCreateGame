package entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import items.Item;

public class ItemEntity extends Entity{

	Item theItem; //das Item, welches zu diesem Entity gehört.
	
	public ItemEntity(float x, float y, Item theItem) {
		super(x, y);
		this.theItem = theItem;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		//Hier soll das Item logisch ueberprueft werden
		hitbox = new Rectangle(posX-5f/32, posY-5f/32, 10f/32, 10f/32);
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		//Hier soll das Item gezeichnet werden. Um zu ueberpruefen um welches
		//Item es sich handelt nutze "theItem instanceof ItemTest"
		shape = new Rectangle(drawX-5, drawY-5, 10, 10);
		g.setColor(Color.gray);
		g.fill(shape);
		g.setColor(Color.orange);
		g.drawString(theItem.displayName, drawX+5, drawY); //Statt Text, Bild einfuegen
	}

}
