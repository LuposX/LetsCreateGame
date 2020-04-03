package menus;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Credits extends BasicGameState{
	
	public Credits(int credits) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Programmer: /", 300, 100);
		g.drawString("Level Designer: /", 300, 150);
		g.drawString("Director: /", 300, 200);
		g.drawString("Music & Sound: Little Robot Sound Factory", 300, 250);
		g.drawString("Texture: spriters-resource.com", 300, 300);
		g.drawString("Back", 30, 430);
		g.drawString("License:  MIT", 780, 450);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//Back button
		if((posX > 25 && posX < 70) && (posY > 30 && posY < 55)){
			//System.out.println("drauf");
			if(Mouse.isButtonDown(0)){
				sbg.enterState(0);
			}
		}
	} 

	public int getID() {
		return 1;
	}	
}
