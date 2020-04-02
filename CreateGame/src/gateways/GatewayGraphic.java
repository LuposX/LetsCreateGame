package gateways;

public class GatewayGraphic {
	
	public static int[][] grid = new int[60][30]; //[X][Y] Verwaltete statische Objekte auf dem Bildschirm
	
	//Gibt das Grid zurück. Manipuliert es gegebenenfalls.
	public static void init() {
		//Debug: Zufällige Blöcke
		for(int x = 0; x < grid.length; x++) {
			for(int y = 0; y < grid[x].length; y++) {
				grid[x][y]=(int)(Math.random()*3);
			}
		}
	}
	
	public static int[][] getGrid() {
		return grid;
	}
}
