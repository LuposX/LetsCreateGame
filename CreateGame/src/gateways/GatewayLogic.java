package gateways;

import org.newdawn.slick.Input;

import logic.LogicControl;

public class GatewayLogic {
	
	//Wird von der Graphik pro Bild aufgerufen.
	//Führt logische Aktivitäten aus.
	public static void sendTick(Input input) {
		LogicControl.tick(input);
	}
	
	public static void init() {
		LogicControl.init();
	}
}
