package entities.hostile;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import logic.Controls;

public abstract class Hostile extends Entity{
	
	public int agro; //Bestimmt, wie sehr der Gegner den Spieler wahrgenommen hat <nicht implementiert>
	public Entity target; //Zeigt auf wen der Gegner aggresiv ist <nicht implementiert>
	
	public Hostile(float x, float y) {
		super(x, y);
		target = Controls.player;
	}
}
