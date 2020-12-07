package logic;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import menus.Settings;
import logic.Controls;

public class Misc {
	public static void init(GameContainer gc, StateBasedGame sbg) {}
	public static void update(GameContainer gc, StateBasedGame sbg, int dt) {}
	
	// Tender function
	public static void render(GameContainer gc, Graphics g) {
		if (Settings.PREF.getBoolean("Developer_Mode", false) == true) {
			//Aufrufen aller Entities
			for(Entity en : Controls.entities) {
				try {
					en.render_entity_hibox(gc, g);
				} catch (Exception e) {
					System.out.println("Failed Entity: " + en.getClass());
					System.out.println("Stacktrace: " + e);
				}
			}
		}
	}
	
}
