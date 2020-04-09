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

	public Item theItem; //das Item, welches zu diesem Entity geh�rt.
	public int pickUpDelay; //Delay, damit man das Item nach dem Droppen nicht direkt wieder einsammelt
	
	public ItemEntity(float x, float y, Item theItem) {
		super(x, y);
		this.theItem = theItem;
		pickUpDelay = 300;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		//Hier soll das Item logisch ueberprueft werden
		updateHitbox();
		
		if(pickUpDelay > 0) {pickUpDelay -= dt;}
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		//Hier soll das Item gezeichnet werden. Um zu ueberpruefen um welches
		//Item es sich handelt nutze "theItem instanceof ItemTest"
		shape = new Rectangle(drawX-15, drawY-15, 30, 30);
		theItem.drawOnScreen(drawX-15, drawY-15, 30, 30, gc, g);
	}
	
	@Override
	public void onCollision(Entity en) {
		if(en instanceof Player) {
			if (pickUpDelay <= 0) {
				Player p = (Player) en;
				if (!p.inventory.isFull()) {
					theItem.currentInventory = p.inventory;
					theItem.currentInventory.add_item_to_Inventory(theItem);
					this.wantToDie = true;
				} else {
					p.inventory.isInventoryFull = true;
					p.inventory.iventoryIsFullMessageDurationAktuell = 0; // used for diplaying inventory is full message
				}
			} else {
				pickUpDelay = 200;
			}
		}
	}

	@Override
	public void updateHitbox() {
		hitbox = new Rectangle(posX-15f/32, posY-15f/32, 30f/32, 30f/32);
	}

}
