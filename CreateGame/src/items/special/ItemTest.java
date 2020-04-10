package items.special;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.player.Inventory;
import items.Item;
import items.armor.Shoe;

public class ItemTest extends Shoe{
	/* Test item
	 * ------------
	 * For Demonstratring how to add a item. This one adds 
	 * Player speed.
	 * 
	 */
	
	public float speed_multiplier = 1.5f;
	public static int cooldown = 300;
	public static String itemName = "Testschuhe";
	public static String itemDescription = "This is a item for testing\npurposes. \nPassive:\n  +50% Speed";
	
	
	public ItemTest() {
		super(itemName, itemDescription);
	}

	@Override
	public void onPassive() {
		if(!isCarried && currentInventory != null && currentInventory.inventory.length > 2&& currentInventory.inventory[2] == this) {
			onPassiveActivation();
		}
		if(isCarried && (currentInventory == null || currentInventory.inventory[2] != this)) {
			onPassiveDeactivation();
		}
	}

	@Override
	public void onActive(GameContainer gc, StateBasedGame sbg, int dt) {
		
	}

	@Override
	public void onPassiveActivation() {
		currentInventory.player.speed *= speed_multiplier;
		isCarried = true;
	}

	@Override
	public void onPassiveDeactivation() {
		currentInventory.player.speed /= speed_multiplier;
		isCarried = false;
	}

	@Override
	public void drawOnScreen(float x, float y, float width, float height, GameContainer gc, Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(x, y, width, height);
	}
}
