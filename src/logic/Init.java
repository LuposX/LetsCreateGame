package logic;

import java.util.prefs.Preferences;

public class Init {
	/* This class is for the Initalization of the Game. For example it creates
	 *  config files when you start the game for the first time.
	 */
	
	// Init for when you start the game for the first time
	public static void init_first_time() {
		Preferences prefs =  Preferences.userRoot().node("LetsCreateGameSettings");
	}
	
}
