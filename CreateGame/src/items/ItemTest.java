package items;

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
}
