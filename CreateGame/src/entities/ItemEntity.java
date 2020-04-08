package entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import items.Item;
import entities.player.Inventory;
import entities.player.Player;

public class ItemEntity extends Entity{

	Item theItem; //das Item, welches zu diesem Entity geh�rt.
	
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
		theItem.drawOnScreen(drawX-5, drawY-5, 10, 10, gc, g);
	}
	
	@Override
	public void onCollision(Entity en) {
		if (en instanceof Player) {
			Player p = (Player) en;
			theItem.currentInventory = p.inventory;
			if (!p.inventory.isFull()) {
				theItem.currentInventory.add_item_to_Inventory(theItem);
				this.wantToDie = true;
			} else {
				p.inventory.isInventoryFull = true;
			}
		}
	}

}
