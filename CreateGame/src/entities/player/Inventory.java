package entities.player;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import items.Item;

public class Inventory {
	/* Inventory class
	 * -------------------
	 * Inventory class. In the Arraylist we save items we picked up.
	 * 
	 */
	
	public ArrayList<Item> inventory; // our Inventory
	public Player player; // our player referenz
	
	public Inventory(Player playerInst) {
		inventory = new ArrayList<Item>(); // Creating a new Arraylist for the Inventory
		player = playerInst; // setting the player Intsanz
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		for(Item item : inventory) {
			item.onPassive();
		}
	}
	
	public void add_item_to_Inventory(Item item) {
		/* When the player collides with a item. This gets executed
		 * 
		 * @param item the item we add to our Inventory
		 * @return void 
		 */
		inventory.add(item); // we add out item to the inventory
		item.onPassiveActivation(); // we execute the passive of our item
	}
	
	public void equip_item_from_Inventory(int idx) {
		/* We equip a item for the activte use.
		 * Equiped is the item on idx = 0
		 * 
		 * @param idx The index of the item we want to equip
		 * @return void 
		 */
		Item temp = inventory.get(0);
		inventory.set(0, inventory.get(idx));
		inventory.set(idx, temp);
	}
}
