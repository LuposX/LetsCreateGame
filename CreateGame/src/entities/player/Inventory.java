package entities.player;

import java.util.ArrayList;

import items.Item;

public class Inventory {
	/* Inventory class
	 * -------------------
	 * Inventory class. In the Arraylist we save items we picked up.
	 * 
	 */
	
	public ArrayList<Item> Inventory; // our Inventory
	public Player player; // our player referenz
	
	public Inventory(Player playerInst) {
		Inventory = new ArrayList<Item>(); // Creating a new Arraylist for the Inventory
		player = playerInst; // setting the player Intsanz
	}
	
	public void add_item_to_Inventory(Item item) {
		/* When we pick up a Item execute this command
		 * 
		 * @param item the item we add to our Inventory
		 * @return void 
		 */
		item.on_pickup(this); // For documentation go into the Item class
		Inventory.add(item); // we add out item to the inventory
		item.onPassive(); // we execute the passive of our item
	}
	
	public void equip_item_from_Inventory(int idx) {
		/* We equip a item for the activte use.
		 * Equiped is the item on idx = 0
		 * 
		 * @param idx The index of the item we want to equip
		 * @return void 
		 */
		Item temp = Inventory.get(0);
		Inventory.set(0, Inventory.get(idx));
		Inventory.set(idx, temp);
	}
}
