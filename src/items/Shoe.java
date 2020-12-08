package items;

public abstract class Shoe extends Item{

	public boolean isCarried = false;
	
	public Shoe(String displayName, String displayLore) {
		super(displayName, displayLore);
	}
	
}
