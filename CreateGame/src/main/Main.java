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
			AppGameContainer app = new AppGameContainer(new Game("Jump�n Run Game"));
			app.setDisplayMode(960, 480, false);
			app.setTargetFrameRate(60);
			app.setVSync(true);
			app.start();
			
		} catch(SlickException e){
			e.printStackTrace();
		}	
		System.out.println("Hallo Karl");
		System.out.println("Hallo Karl");
		System.out.println("Hallo Karl");
		System.out.println("Hallo Karl");
		System.out.println("Hallo Karl");
		System.out.println("Hallo 1234");
	}
}
