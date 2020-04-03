package menu;

import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Start extends BasicGameState{
	
	public Start(int startmenu) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString("Play", 450, 170);
		g.drawString("Settings", 450, 220);
		g.drawString("Credits", 450, 270);
		g.drawString("Exit", 450, 320);
		g.drawString("Version: 1.3", 10, 450);
		g.drawString("License: CC-BY 4.0", 780, 450);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//System.out.println("X:" + posX + "Y:" + posY);
		
		//Play button
		if((posX > 445 && posX < 490) && (posY > 290 && posY < 310)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(1);
			}
		}
		
		//Settings button
		if((posX > 445 && posX < 520) && (posY > 240 && posY < 260)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(4);
				}
			}
		
		//Exit button
		if((posX > 430 && posX < 510) && (posY > 140 && posY < 160)){
			if(Mouse.isButtonDown(0)){
				AL.destroy();
				System.exit(0);
				}
		}
		
		//Credits Button
		if((posX > 445 && posX < 520) && (posY > 190 && posY < 210)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(3);
			}
		}
	}

	public int getID() {
		return 0;
	}	
}
