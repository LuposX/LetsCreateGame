package entities;

//Eigentlich abstarkt; Objekterstellung nur testweise
public class DrawEntity {
	public float drawX;
	public float drawY;
	
	public int entityID;
	public int drawID;
	
	public DrawEntity(float x, float y, int entityID) {
		this.drawX = x;
		this.drawY = y;
		this.entityID = entityID;
		
		this.drawID = entityID; //Vorl�ufig; Sp�ter: entityID != drawID
	}
	
	//F�hrt die Logic des Objektes ein.
	//Wird bei der Vererbung �berschrieben
	//Kann als abstrakt behandelt werden
	public void tick() {
		
	}
}
