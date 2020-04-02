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
		
		//Debug: Hinzuf�gen einiger Test-Entities
		entities.add(new DrawEntity(10.5f, 10.35f, 0));
		entities.add(new DrawEntity(20.5f, 25.5f, 1));
		
	}
	
	public static int[][] getGrid() {
		return grid;
	}
	
	public static ArrayList<DrawEntity> getEntities(){
		
		//Debug:
		//Ver�ndern der Koordinaten eines der Objekte
		entities.get(0).drawX += 0.03;
		
		
		return entities;
	}
}
