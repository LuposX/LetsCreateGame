package items.weapons;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.player.Inventory;
import entities.projectile.special.ProjectileSnowball;
import items.Item;
import logic.Camera;
import logic.Controls;

public class ItemSnowball extends Item{
	/* Snowball item
	 * ------------
	 * 
	 */
	
	
	public ItemSnowball() {
		super("Snowballgun","Active: \nthroughs a snowball \ninto your face");
	}

	@Override
	public void onPassive() {
	}

	@Override
	public void onActive(GameContainer gc, StateBasedGame sbg, int dt) {
		Controls.entities.add(new ProjectileSnowball(currentInventory.player.posX, currentInventory.player.posY, Camera.getMouseX(gc.getInput())/Controls.tileSize, Camera.getMouseY(gc.getInput())/Controls.tileSize, currentInventory.player));
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