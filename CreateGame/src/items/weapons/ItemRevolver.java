package items.weapons;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entities.player.Inventory;
import entities.projectile.special.ProjectileRevolver;
import entities.projectile.special.ProjectileSnowball;
import items.Item;
import logic.Camera;
import logic.Controls;

public class ItemRevolver extends Item{
	/* Snowball item
	 * ------------
	 * 
	 */
	
	public static int cooldownMax = 1000;
	public static String itemName = "Revolver";
	public static String itemDescription = "Active: \n Shoot grist into \n your enemy faces";
	
	public ItemRevolver() {
		super(itemName, itemDescription, cooldownMax);

		//try {
		//		image = new Image("res/textures/items/snowgun.png");
		//} catch (SlickException e) {
		//	e.printStackTrace();
		//}
	}

	@Override
	public void onPassive() {
	}

	@Override
	public void onActive(GameContainer gc, StateBasedGame sbg, int dt) {
		Controls.entities.add(new ProjectileRevolver(currentInventory.player.posX, currentInventory.player.posY, Camera.getMouseX(gc.getInput())/Controls.tileSize, Camera.getMouseY(gc.getInput())/Controls.tileSize, currentInventory.player));
	}

	@Override
	public void onPassiveActivation() {
	}

	@Override
	public void onPassiveDeactivation() {

	}

	@Override
	public void drawOnScreen(float x, float y, float width, float height, GameContainer gc, Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}
