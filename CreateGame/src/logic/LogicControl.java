package logic;

import java.util.ArrayList;

import org.newdawn.slick.Input;

import entities.DrawEntity;
import entities.Player;
import gateways.GatewayGraphic;

//Die Klasse gilt als Verteiler an alle Logic Elemente
public class LogicControl {
	
	public static ArrayList<DrawEntity> entities = GatewayGraphic.entities;
	
	//Wird beim Erstellen eines Spiels ausgeführt
	public static void setup() {
		
	}
	
	//Wird beim Betreten des Ingame-Bildscirms ausgeführt
	public static void init() {
		setup(); //vorerst
		
		//Debug: Hinzufügen einiger Test-Entities
		entities.add(new Player(10.5f, 10.35f));
		entities.add(new DrawEntity(20.5f, 25.5f, 1));
	}
	
	//Wird tickweise ausgeführt
	public static void tick(Input input) {
		
		//Alle Ticks der Entities ausführen
		for(DrawEntity de : entities) {
			de.tick();
		}
	}
}
