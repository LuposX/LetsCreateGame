package items;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import entities.player.Inventory;

public class ItemTest extends Item{
	/* Test item
	 * ------------
	 * For Demonstratring how to add a item. This one adds 
	 * Player speed.
	 * 
	 */
	
	public int speed_multiplier = 2;
	
	public ItemTest() {
		super("Das Mega Test Item");
	}

	@Override
	public void onPassive() {
	}

	@Override
	public void onActive() {
		
	}

	@Override
	public void onPassiveActivation() {
		currentInventory.player.speed *= 2;
	}

	@Override
	public void onPassiveDeactivation() {

	}

	@Override
	public void drawOnScreen(float x, float y, float width, float height, GameContainer gc, Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(x, y, width, height);
		g.setColor(Color.orange);
		g.drawString(displayName, x+5, y);
	}
}
