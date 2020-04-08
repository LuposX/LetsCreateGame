package entities.player;

import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import entities.ItemEntity;
import items.Item;
import logic.Controls;

public class Inventory {
	/* Inventory class
	 * -------------------
	 * Inventory class. In the Arraylist we save items we picked up.
	 * 
	 */
	
	public Player player; // our player referenz
	public int InventarSlots = 8; // How much you can put in your Inventory
	public Item[] inventory; // our Inventory
	
	public boolean isOpen = false; //Zeigt ob das Inv geoeffnet ist
	public boolean isInventoryFull = false; // Zeigt ob das Inventory full ist
	
	public float drawUnit = 0; //Einheit zum Zeichnen des Bildschirms
	public int lastClickedSlot = -1; //SlotID des zuletzt geklickten Slots
	public int iventoryIsFullMessageDurationMax = 1000; // how long the message should stay on the screen
	public int iventoryIsFullMessageDurationAktuell = iventoryIsFullMessageDurationMax + 2;
	
	public Inventory(Player playerInst) {
		inventory = new Item[0]; // Creating a new Arraylist for the Inventory
		player = playerInst; // setting the player Intsanz
	}
	
	public boolean isFull() {
		
		if(inventory.length < InventarSlots) {return false;}
		
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i] == null) {
				return false;
			}
		}
		
		return true;
	}
	
	public void append_to_Inventory(Item item) {
		/* This methods appends the inventory array and add a item to it.
		 * 
		 * @param item the item that gets appended to out inventory array
		 * @return void
		 */
		if (inventory.length >= InventarSlots) {
			boolean isFull = true;
			for(int i = 0; i < inventory.length; i++) {
				if(inventory[i] == null) {
					isFull = false;
					isInventoryFull = false;
					inventory[i] = item;
					break;
				}
			}
			if(isFull) {
				System.err.print("inventar full");
				isInventoryFull = true;
			}
		} else {
			isInventoryFull = false;
			inventory = Arrays.copyOf(inventory, inventory.length + 1);
			inventory[inventory.length - 1] = item;
		}
	}
	
	public void message_Inventory_full(GameContainer gc, Graphics g) {
		/* Gets displayed when the Inventory is full
		 * 
		 * @param g used to draw stuff, gets it from render method
		 * @return void
		 */
		g.setColor(Color.red);
		g.drawString("Inventory is full", gc.getWidth() / 2, gc.getHeight() / 2);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int dt) {
		
		// gets executed to minimize cooldown for error message
		if(iventoryIsFullMessageDurationAktuell <= iventoryIsFullMessageDurationMax) {
			iventoryIsFullMessageDurationAktuell += dt;
		}
		
		for(Item item : inventory) {
			if(item != null) {
				item.onPassive();
			}
		}
		if(gc.getInput().isKeyPressed(Input.KEY_E)) {
			isOpen = !isOpen;
		}
		
		//Ueberpruefen von Inventarklicks
		if(isOpen) {
			if(gc.getInput().isMousePressed(0)) {
				lastClickedSlot = getSlot(gc.getInput().getMouseX(), gc.getInput().getMouseY());
			}
			if(lastClickedSlot != -1 && !gc.getInput().isMouseButtonDown(0)) {
				//Loslassen des Items
				
				int cSlot = getSlot(gc.getInput().getMouseX(), gc.getInput().getMouseY());
				
				if(cSlot != -1 && cSlot < inventory.length && lastClickedSlot < inventory.length && inventory[lastClickedSlot] != null) {
					Item temp = inventory[lastClickedSlot];
					inventory[lastClickedSlot] = inventory[cSlot];
					inventory[cSlot] = temp;
				}
				
				lastClickedSlot = -1;
			}
		}
		//Fuellen des Inventars mit leeren Objekten
		if(isOpen) {
			if(inventory.length < InventarSlots) {
				append_to_Inventory(null);
			}
		}
		
		//Droppen von Items
		if(gc.getInput().isKeyPressed(Input.KEY_Q) && isOpen) {
			dropItem(getSlot(gc.getInput().getMouseX(), gc.getInput().getMouseY()));
		}
	}
	
	public void render(GameContainer gc, Graphics g) {
		
		drawUnit = gc.getHeight()/480f;
		
		if(iventoryIsFullMessageDurationAktuell <= iventoryIsFullMessageDurationMax) {
			message_Inventory_full(gc, g);
		} 
		
		if(isOpen) {
			//Draw Windows
			Color color1 = new Color(Color.lightGray);
			color1.a = 0.8f;
			g.setColor(color1);
			g.fillRoundRect(10*drawUnit, 10*drawUnit, 500*drawUnit, 460*drawUnit, (int) (50*drawUnit));
			g.setColor(Color.orange);
			g.drawString("Aktive Items:", 30*drawUnit, 25*drawUnit);
			g.drawString("Sonstige Items:", 30*drawUnit, 120*drawUnit);
			
			//Draw Slots
			g.setColor(Color.black);
			g.setLineWidth(5*drawUnit);
			
			g.drawRect(30*drawUnit, 50*drawUnit, 50*drawUnit, 50*drawUnit);
			g.drawRect(100*drawUnit, 50*drawUnit, 50*drawUnit, 50*drawUnit);
			
			for(int i = 0; i < InventarSlots-2; i++) {
				float x = (30+(i % 6)*70)*drawUnit;
				float y = (160+(int)(i / 6)*70)*drawUnit;
				
				g.drawRect(x, y, 50*drawUnit, 50*drawUnit);
			}
			
			g.resetLineWidth();
			
			//Draw Items
			for(int i = 0; i < inventory.length; i++) {
				Item item = inventory[i];
				if(item != null) {
					if(i == 0) {
						item.drawOnScreen(30*drawUnit, 50*drawUnit, 50*drawUnit, 50*drawUnit, gc, g);
					} else if(i == 1) {
						item.drawOnScreen(100*drawUnit, 50*drawUnit, 50*drawUnit, 50*drawUnit, gc, g);
					} else {
						float x = (30+((i-2) % 6)*70)*drawUnit;
						float y = (160+(int)((i-2) / 6)*70)*drawUnit;
						item.drawOnScreen(x, y, 50*drawUnit, 50*drawUnit, gc, g);
					}
				}
			}
			
			//Zeichnen eines getragenen Items
			if(lastClickedSlot != -1 && lastClickedSlot < inventory.length && inventory[lastClickedSlot] != null) {
				Item item = inventory[lastClickedSlot];
				item.drawOnScreen(gc.getInput().getMouseX()-15*drawUnit, gc.getInput().getMouseY()-15*drawUnit, drawUnit*30, drawUnit*30, gc, g);
			}
			
			//Itembeschreibung
			int hoverSlot = getSlot(gc.getInput().getMouseX(), gc.getInput().getMouseY());
			if(hoverSlot != -1 && hoverSlot < inventory.length && inventory[hoverSlot] != null) {
				Item item = inventory[hoverSlot];
				
				g.setColor(Color.blue);
				g.fillRoundRect(gc.getInput().getMouseX()+20, gc.getInput().getMouseY()+10, 300, 70+item.displayLore.split("\n").length*20,5);
				g.setColor(Color.orange);
				g.drawString(item.displayName + ":", gc.getInput().getMouseX()+30, gc.getInput().getMouseY()+30);
				g.setColor(Color.magenta);
				g.drawString(item.displayLore, gc.getInput().getMouseX()+30, gc.getInput().getMouseY()+60);
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
	
	public int getSlot(float x, float y) {
		/* Gibt den Slot zurueck, der auf den Koordinaten liegt.
		 * Befindet sich dort kein Slot, so wird -1 zurueckgegeben.
		 * @param x Die X-Koordinate des gesuchten Slots, y Die Y-Koordinate des gesuchten Slots
		 * @return void 
		 */
		
		if(x > 30*drawUnit && y > 50*drawUnit && x < 80*drawUnit && y < 100*drawUnit) {
			return 0;
		}
		if(x > 100*drawUnit && y > 50*drawUnit && x < 150*drawUnit && y < 100*drawUnit) {
			return 1;
		}
		
		for(int i = 0; i < InventarSlots-2; i++) {
			float mX = (30+(i % 6)*70)*drawUnit;
			float mY = (160+(int)(i / 6)*70)*drawUnit;
			
			if(x > mX && y > mY && y < mY + 50*drawUnit && x < mX + 50*drawUnit) {
				return i + 2;
			}
		}
		
		return -1;
	}
	
	public void dropItem(int itemSlot) {
		/* Dropt das Item vom gegebenen Slot
		 * @param itemSlot Die ID des Slots
		 * @return void 
		 */
		if(itemSlot != -1 && itemSlot < inventory.length && inventory[itemSlot] != null) {
			Item item = inventory[itemSlot];
			
			Controls.entities.add(new ItemEntity(player.posX, player.posY, item));
			inventory[itemSlot] = null;
			item.onPassiveDeactivation(); // we deactivate the passive of our item
			item.currentInventory = null;
		}
	}
}
