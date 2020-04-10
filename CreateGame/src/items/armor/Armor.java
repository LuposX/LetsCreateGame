package items.armor;

import items.Item;

public abstract class Armor extends Item{

	public boolean isCarried = false;
	
	public Armor(String displayName, String displayLore) {
		super(displayName, displayLore);
	}
	
}
