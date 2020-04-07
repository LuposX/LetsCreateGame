package entities.player;

import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import items.Item;

public class Inventory {
	/* Inventory class
	 * -------------------
	 * Inventory class. In the Arraylist we save items we picked up.
	 * 
	 */
	
	public Player player; // our player referenz
	public boolean isOpen = false; //Zeigt ob das Inv geoeffnet ist
	public int InventarSlots = 8; // How much you can put in your Inventory
	public Item[] inventory; // our Inventory
	
	public Inventory(Player playerInst) {
		inventory = new Item[0]; // Creating a new Arraylist for the Inventory
		player = playerInst; // setting the player Intsanz
	}
	
	public void append_to_Inventory(Item item) {
		if (inventory.length >= InventarSlots) {
			System.err.print("inventar full");
		} else {
			inventory = Arrays.copyOf(inventory, inventory.length + 1);
			inventory[inventory.length - 1] = item;
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		for(Item item : inventory) {
			if (item != null) {
				item.onPassive();
			}
		}
		if(gc.getInput().isKeyPressed(Input.KEY_E)) {
			isOpen = !isOpen;
		}
	}
	
	public void render(GameContainer gc, Graphics g) {
		if(isOpen) {
			//Draw Windows
			g.setColor(Color.lightGray);
			g.fillRoundRect(10, 10, 500, 460, 50);
			g.setColor(Color.orange);
			g.drawString("Aktive Items:", 30, 25);
			g.drawString("Sonstige Items:", 30, 120);
			
			//Draw Slots
			g.setColor(Color.black);
			g.setLineWidth(5);
			
			g.drawRect(30, 50, 50, 50);
			g.drawRect(100, 50, 50, 50);
			
			for(int i = 0; i < InventarSlots-2; i++) {
				float x = 30+(i % 6)*70;
				float y = 160+(int)(i / 6)*70;
				
				g.drawRect(x, y, 50, 50);
			}
			
			g.resetLineWidth();
			
			//Draw Items
			for(int i = 0; i < inventory.length; i++) {
				Item item = inventory[i];
				if (item != null) {
				if(i == 0) {
					item.drawOnScreen(30, 50, 50, 50, gc, g);
				} else if(i == 1) {
					item.drawOnScreen(100, 50, 50, 50, gc, g);
				} else {
					float x = 30+((i-2) % 6)*70;
					float y = 160+(int)((i-2) / 6)*70;
					item.drawOnScreen(x, y, 50, 50, gc, g);
				}
			  }
			}
		}
	}
	
	public void add_item_to_Inventory(Item item) {
		/* When the player collides with a item. This gets executed
		 * 
		 * @param item the item we add to our Inventory
		 * @return void 
		 */
		append_to_Inventory(item); // we add out item to the inventory
		item.onPassiveActivation(); // we execute the passive of our item
	}
	
	public void equip_item_from_Inventory(int idx) {
		/* We equip a item for the activte use.
		 * Equiped is the item on idx = 0
		 * 
		 * @param idx The index of the item we want to equip
		 * @return void 
		 */
		Item temp = inventory[0];
		inventory[0] = inventory[idx];
		inventory[idx] = temp;
	}
}
