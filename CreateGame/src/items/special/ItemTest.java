package items.special;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.player.Inventory;
import items.Item;

public class ItemTest extends Item{
	/* Test item
	 * ------------
	 * For Demonstratring how to add a item. This one adds 
	 * Player speed.
	 * 
	 */
	
	public float speed_multiplier = 1.1f;
	
	public ItemTest() {
		super("Testitem","This is a item for testing\npurposes. \nPassive:\n+10% Speed");
	}

	@Override
	public void onPassive() {
	}

	@Override
	public void onActive(GameContainer gc, StateBasedGame sbg, int dt) {
		
	}

	@Override
	public void onPassiveActivation() {
		currentInventory.player.speed *= speed_multiplier;
	}

	@Override
	public void onPassiveDeactivation() {
		currentInventory.player.speed /= speed_multiplier;
	}

	@Override
	public void drawOnScreen(float x, float y, float width, float height, GameContainer gc, Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(x, y, width, height);
	}
}
