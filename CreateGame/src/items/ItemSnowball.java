package items;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import accessibility.Translator;
import entities.player.Inventory;
import entities.projectile.ProjectileSnowball;
import logic.Controls;

public class ItemSnowball extends Item{
	/* Snowball item
	 * ------------
	 * 
	 */
	
	
	public ItemSnowball() {
		super("Snow");
	}

	@Override
	public void onPassive() {
	}

	@Override
	public void onActive(GameContainer gc, StateBasedGame sbg, int dt) {
		Controls.entities.add(new ProjectileSnowball(currentInventory.player.posX, currentInventory.player.posY, gc.getInput().getMouseX()/Controls.tileSize, gc.getInput().getMouseY()/Controls.tileSize, currentInventory.player));
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
		g.setColor(Color.orange);
		g.drawString(Translator.get("item.snow.name"), x+5, y);
	}
}
