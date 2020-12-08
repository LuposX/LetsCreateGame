package items.armor;

import items.Item;

public abstract class Shoe extends Item{

	public boolean isCarried = false;
	
	public Shoe(String displayName, String displayLore) {
		super(displayName, displayLore);
	}
	
}
