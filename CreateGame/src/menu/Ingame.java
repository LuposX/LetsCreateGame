package menu;

import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.DrawEntity;
import gateways.GatewayGraphic;
import gateways.GatewayLogic;

public class Ingame extends BasicGameState{
	
	public Ingame(int startmenu) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		GatewayGraphic.init();
	}

	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		GatewayLogic.sendTick(); //Gibt update weiter
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.black);
		
		int[][] drawGrid = GatewayGraphic.getGrid();
		
		//Abarbeiten der Grid-Slots
		float blockWidth = 1.0f*gc.getWidth()/drawGrid.length; //Breite eines Blockes
		float blockHeight = 1.0f*gc.getHeight()/drawGrid[0].length; //Höhe eines Blockes
		for(int x = 0; x < drawGrid.length; x++) {
			for(int y = 0; y < drawGrid[x].length; y++) {
				//Todo: Umformen in übersichtliche Methode
				
				g.setColor(Color.white);
				switch(drawGrid[x][y]) {
					case 0: g.setColor(Color.black); break;
					case 1: g.setColor(Color.red); break;
					case 2: g.setColor(Color.green); break;
				}
				
				
				g.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
			}
		}
		//Ende: Blöcke
		
		//Entities
		for(DrawEntity de : GatewayGraphic.getEntities()) {
			//Für jedes Entity
			
			//Todo: statt Farbe, Textur
			g.setColor(Color.white);
			switch(de.drawID) {
				case 0: g.setColor(Color.yellow); break;
				case 1: g.setColor(Color.pink); break;
			}
			
			g.fillOval(de.drawX*blockWidth, de.drawY*blockHeight, 2*blockWidth, 2*blockHeight);
		}
	}


	public int getID() {
		return 1;
	}	
}
