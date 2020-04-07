package items;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import entities.player.Inventory;
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
	public Inventory currentInventory = null; // Inventar in which it is
	
	public Item(String displayName) {
		this.displayName = displayName;
	}
	
	//Malt das Item bei den Koordinaten mit den geg. Ma�en
	public abstract void drawOnScreen(float x, float y, float width, float height, GameContainer gc, Graphics g);
	
	//Wird ausgef�hrt, wenn passiv (im Inventar) ausgef�hrt (jedes update)
	public abstract void onPassive();
	
	//Wird ausgef�hrt, wenn das Item aktiv benutzt wird.
	public abstract void onActive();	
	
	public abstract void onPassiveActivation(); //Wird ausgefuehrt, wenn Passive aktiviert wird
	public abstract void onPassiveDeactivation(); //Gegenteil von Activation
}
