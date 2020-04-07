package accessibility;

public class Translator {
	public static int language = 1; //0 = Deutsch //1 = Englisch
	
	//Gibt den String in der Richtigen Sprache
	public static String get(String s) {
		if(language == 0) {return german(s);}
		if(language == 1) {return english(s);}
		return "Language not available";
	}
	
	public static String english(String s) {
		
		if(s.equalsIgnoreCase("item.snow.name")){return "Snow";}
		
		return "not available in this language";
	}
	
	public static String german(String s) {
		if(s.equalsIgnoreCase("item.snow.name")){return "Schnee";}
		
		return "not available in this language";
	}
}
