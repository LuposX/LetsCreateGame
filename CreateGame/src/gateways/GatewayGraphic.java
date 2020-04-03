package gateways;

import java.util.ArrayList;

import entities.DrawEntity;

public class GatewayGraphic {
	
	public static int[][] grid = new int[60][30]; //[X][Y] Verwaltete statische Objekte auf dem Bildschirm
	public static ArrayList<DrawEntity> entities = new ArrayList<DrawEntity>();
	
	//Gibt das Grid zur�ck. Manipuliert es gegebenenfalls.
	public static void init() {
		//Debug: Zuf�llige Bl�cke
		for(int x = 0; x < grid.length; x++) {
			for(int y = 0; y < grid[x].length; y++) {
				grid[x][y]=(int)(Math.random()*3);
			}
		}
	}
	
	public static int[][] getGrid() {
		return grid;
	}
	
	public static ArrayList<DrawEntity> getEntities(){
		
		return entities;
	}
}
