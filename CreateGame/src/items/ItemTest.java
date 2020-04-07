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
		currentInventory.player.speed *= 2;
	}

	@Override
	public void onActive() {
		
	}

	@Override
	public void on_pickup(Inventory pickUpInventory) {
		currentInventory = pickUpInventory;
	}

}
