package items;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import logic.Controls;

public abstract class Item {
	public float posX;
	public float posY;
	public float drawX;
	public float drawY;
	
	public boolean wantToDie = false; //Wenn true wird es von der Loop in Controls/update gel�scht
	public int age = 0; //Eigenschaft die von Erbenden Methoden genutzt werden kann
	
	/* Abstract Item class
	 * ----------
	 * This class is a abstract Item class. Specific items should inherit from it
	 * 
	 *  Create a new Item:
	 *  1. Create a New class with the name of the Item
	 *  2. let it inherit from the Item class e.g. "public class SuperCoolWeapon extends Item { .... }"
	 *  3. Implement the abstract methods
	 */
	
	public Item(float x, float y) {
		posX = x;
		posY = y;
	}
	
	public abstract void update(GameContainer gc, StateBasedGame sbg, int dt); //Dient zum Updaten von Physik und Logik
	public abstract void render(GameContainer gc, Graphics g); //Dient zum Zeichnen der Graphik
	
	//Macht Berechnungen vor dem Rendern aus, welche die Graphik betreffen
	//Darf nicht ueberschrieben werden
	public void prepareDraw() {
		drawX = posX * Controls.tileSize;
		drawY = posY * Controls.tileSize;
	}
	
	//<nicht implementiert>
	//Input: Aktiver Kollisionsteilnehmer
	//Wird aufgerufen wenn (z.B. ein Projektil) dieses Entity trifft.
	public void onCollision(Entity en) {
		//Hier nichts reinschreiben. In den Unterklassen (durch �berschreiben) implementieren
	}
}
