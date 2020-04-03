package entities;

public class Player extends DrawEntity{

	public Player(float x, float y) {
		super(x, y, 0); //Entity ID ist immer 0 bei Spieler
	}
	
	public void tick() {
		//Debug: Bewegen des Spielers
		this.drawX += 0.01;
	}

}
