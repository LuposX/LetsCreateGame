package entities.player;

import java.util.ArrayList;

import items.Item;

public class Inventory {
	
	public ArrayList<Item> Inventory;
	
	public Inventory() {
		Inventory = new ArrayList<Item>();
	}
	
	public void add_item_to_Inventory(Item item) {
		Inventory.add(item);
	}
}
