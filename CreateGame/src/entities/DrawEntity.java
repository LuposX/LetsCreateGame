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
		
		this.drawID = entityID; //Vorläufig; Später: entityID != drawID
	}
	
	//Führt die Logic des Objektes ein.
	//Wird bei der Vererbung überschrieben
	//Kann als abstrakt behandelt werden
	public void tick() {
		
	}
}
