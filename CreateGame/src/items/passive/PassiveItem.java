package items.passive;

import items.Item;

public abstract class PassiveItem extends Item{

	public boolean isCarried = false;
	
	public PassiveItem(String displayName, String displayLore) {
		super(displayName, displayLore);
	}
	
}
