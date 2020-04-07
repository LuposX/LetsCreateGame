package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

import logic.Controls;

public abstract class Entity {
	public float posX;
	public float posY;
	public float drawX;
	public float drawY;
	public Shape shape;
	public Shape hitbox;
	public boolean wantToDie = false; //Wenn true wird es von der Loop in Controls/update gel�scht
	public int age = 0; //Eigenschaft die von Erbenden Methoden genutzt werden kann
	public float health; //HP des Entities
		
	public float speed; //Eigenschaft die die Geschwindigkeit es Entitys bestimmen soll [Standart: 1]
	public float aktuellerSpeed;
	
	/* Abstract Entity class
	 * ----------
	 * This class is a abstract Entity class. Specific Entities should inherit from it.
	 * 
	 *  Create a new Entity:
	 *  1. Create a New class with the name of the Entity
	 *  2. let it inherit from the Item class e.g. "public class SuperCoolEnemy extends Entity { .... }"
	 *  3. Implement the abstract methods
	 */
	
	public Entity(float x, float y){
		posX = x;
		posY = y;
	}
	
	public abstract void update(GameContainer gc, StateBasedGame sbg, int dt); //Dient zum Updaten von Physik und Logik
	public abstract void render(GameContainer gc, Graphics g); //Dient zum Zeichnen der Graphik
	
	// maybe rename this method 
	// used to make the game frame independent
	public void prepare_speed(int dt) {
		aktuellerSpeed = speed * dt / 1000.0f;
	}
	
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
