package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import main.Game;

public class Main {
	/* This is out Main class from which the game gets started,
	 * here we can change settings like FPS, how big the window should be
	 * and ect.
	 */
	public static void main(String[] args){
		try{
			AppGameContainer app = new AppGameContainer(new Game("Dungon Game"));
			app.setDisplayMode(960, 480, false); // Size of Window
			app.setTargetFrameRate(60); // How much fps
			app.setVSync(false); // VSNC True or False
			app.start();
			
		} catch(SlickException e){
			System.err.println("Fehler beim Initialisieren des App Containers");
			e.printStackTrace();
		}	
	}
}
