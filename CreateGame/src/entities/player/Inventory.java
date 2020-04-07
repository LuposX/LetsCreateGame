package entities.player;

import java.util.ArrayList;

import items.Item;

public class Inventory {
	
	public ArrayList<Item> Inventory; // our Inventory
	public Player player; // our player referenz
	
	public Inventory(Player playerInst) {
		Inventory = new ArrayList<Item>();
		player = playerInst;
	}
	
	public void add_item_to_Inventory(Item item) {
		Inventory.add(item);
	}
}
