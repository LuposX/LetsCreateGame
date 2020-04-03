package main;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import menu.Ingame;
import menu.MainMenu;

public class Game extends StateBasedGame {
	// Here we define our Game-States a Game-States is like a new Screen or like a level
	// Every Game-State has a special number assigned to it with which we can "run/load" the state
	public static final String GAMENAME = "My Jumpn Run Game";
	public static final int STARTMENU = 0; // we give out start Menu the id 0
	public static final int INGAME = 1; // we give out start Ingame the id 1
		
	public Game(String gameName) {
		super(gameName);
		this.addState(new MainMenu(STARTMENU)); // We add out state to the object Game
		this.addState(new Ingame(INGAME));
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.enterState(STARTMENU);
	}

}
