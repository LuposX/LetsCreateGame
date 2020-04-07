package items;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import logic.Controls;

public abstract class Item {
	/* Abstract Item class
	 * ----------
	 * This class is a abstract Item class. Specific items should inherit from it
	 * 
	 *  Create a new Item:
	 *  1. Create a New class with the name of the Item
	 *  2. let it inherit from the Item class e.g. "public class SuperCoolWeapon extends Item { .... }"
	 *  3. Implement the abstract methods
	 */
	
	public String displayName; //Anzeige Name
	public String[] displayLore; //Anzeige Beschreibung
	//public Inventory currentInventory = null;
	
	public Item(String displayName) {
		this.displayName = displayName;
	}
	
	//Wird ausgeführt, wenn passiv (im Inventar) ausgeführt (jedes update)
	public abstract void onPassive();
	
	//Wird ausgeführt, wenn das Item aktiv benutzt wird.
	public abstract void onActive();
	
}
