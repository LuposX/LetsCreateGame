package logic;

import java.util.ArrayList;

import entities.Entity;

public class PathFinder {
	public static boolean isEyeContact(Entity e1, Entity e2) {
		/** Is searching a Eye-Contact between the Entities
		 * @param e1 the first Entity, e2 the second ENtity
		 * @return boolean true if there is a eye-contact
		 **/
		
		return isEyeContact(e1.posX, e1.posY, e2.posX, e2.posY);
	}
	
	public static boolean isEyeContact(float x1, float y1, float x2, float y2) {
		/** Is searching a Eye-Contact between the Cordinates
		 * @param x1, y1, x2, y2 are the cordinates
		 * @return boolean true if there is a eye-contact
		 **/
		
		int checks = (int) (5 * Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
		
		for(int i = 0; i < checks; i++) {
			int cx = (int) (x1+((x2-x1)/checks)*i);			
			int cy = (int) (y1+((y2-y1)/checks)*i);	
			
			if(Controls.map.getTileId(cx, cy, Controls.LAYER_WALL) != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static ArrayList<int[]> findPath(int x1, int y1, int x2, int y2){
		/** Gibt den kuerzesten Pfad zwischen zwei Tiles zurueck
		 * @param x1 und y1 sind die Start-Koordinaten, x2 und y2 sind die Endkoordinaten
		 * @return Es wird der kuerzeste Pfad in Form einer ArrayList zurueckgegeben. Es sind alle zu betretenen Tiles in der umgekehrten
		 * Reihenfolge angegeben. Ist der Pfad in einer bestimmten Rechenzeit nicht moeglch, so wird eine leere Liste zurueckgegeben
		 */
		
		//Die Arrays innerhalb der Listen sind wie folgt organisiert:
		//[x,y,entfernung zum Ziel,Entfernung Ziel + Entfernung Start,parentX,parentY];
		ArrayList<int[]> openList = new ArrayList<int[]>();
		ArrayList<int[]> closedList = new ArrayList<int[]>();
		
		boolean isPossible = false;
		
		int[] lastNode = {}; //For backtracking later
		
		//Adding Start to the openList
		int[] start = {x1,y1,Math.abs(x1-x2)+Math.abs(y1-y2),Math.abs(x1-x2)+Math.abs(y1-y2),x1,y1};
		openList.add(start);
		
		int iterations = 0;
		while(iterations < 400 && openList.size() > 0) {
			iterations++;
			
			//Searching (open) dot with lowest cost
			int[] bestNode = openList.get(0);
			int bestFCost = bestNode[2];
			int bestHCost = bestNode[3];
			
			for(int i = 0; i < openList.size(); i++) {
				int[] cNode = openList.get(i);
				if(cNode[3] < bestHCost) {
					bestNode = cNode;
					bestHCost = cNode[3];
					bestFCost = cNode[2];
				} else if(cNode[3] == bestHCost && cNode[2] < bestFCost) {
					bestNode = cNode;
					bestHCost = cNode[3];
					bestFCost = cNode[2];
				}
			}
			
			//Testen ob das Ziel erreicht ist
			if(bestNode[0] == x2 && bestNode[1] == y2) {
				isPossible = true;
				lastNode = bestNode;
				break;
			}
			
			//Testen ob die Node schon in der closedList ist
			boolean isAlreadyInList = false;
			for(int i = 0; i < closedList.size(); i++) {
				int[] cNode = closedList.get(i);
				if(cNode[0] == bestNode[0] && cNode[1] == bestNode[1]) {
					isAlreadyInList = true;
					break;
				}
			}
	
			
			
			openList.remove(bestNode);
			closedList.add(bestNode);
			
			if(!isAlreadyInList && !CollisionControler.isCordInLayer(bestNode[0], bestNode[1], Controls.LAYER_WALL)) {
				int[] nNode1 = {bestNode[0]+1,bestNode[1]+0,Math.abs(bestNode[0]+1-x2)+Math.abs(bestNode[1]+0-y2),Math.abs(bestNode[0]+1-x2)+Math.abs(bestNode[1]+0-y2)+bestNode[3]+1-bestNode[2],bestNode[0],bestNode[1]};
				openList.add(nNode1);
				
				int[] nNode2 = {bestNode[0]-1,bestNode[1]+0,Math.abs(bestNode[0]-1-x2)+Math.abs(bestNode[1]+0-y2),Math.abs(bestNode[0]-1-x2)+Math.abs(bestNode[1]+0-y2)+bestNode[3]+1-bestNode[2],bestNode[0],bestNode[1]};
				openList.add(nNode2);
				
				int[] nNode3 = {bestNode[0]+0,bestNode[1]+1,Math.abs(bestNode[0]+0-x2)+Math.abs(bestNode[1]+1-y2),Math.abs(bestNode[0]+0-x2)+Math.abs(bestNode[1]+1-y2)+bestNode[3]+1-bestNode[2],bestNode[0],bestNode[1]};
				openList.add(nNode3);
				
				int[] nNode4 = {bestNode[0]+0,bestNode[1]-1,Math.abs(bestNode[0]+0-x2)+Math.abs(bestNode[1]-1-y2),Math.abs(bestNode[0]+0-x2)+Math.abs(bestNode[1]-1-y2)+bestNode[3]+1-bestNode[2],bestNode[0],bestNode[1]};
				openList.add(nNode4);
			}
		}
		
		ArrayList<int[]> back = new ArrayList<int[]>();
		
		if(!isPossible) {
			return back;
		}
		
		//Backtracking the path
		int lastX = x2;
		int lastY = y2;
		
		int[] lastEntry = {lastNode[0],lastNode[1]};
		back.add(lastEntry);
		while(!(lastX == x1 && lastY == y1)) {
			
			for(int i = 0; i < closedList.size(); i++) {
				int[] cNode = closedList.get(i);
				
				if(cNode[0] == lastNode[4] && cNode[1] == lastNode[5]) {
					int[] newEntry = {cNode[0],cNode[1]};
					back.add(newEntry);
					lastNode = cNode;
					lastX = cNode[0];
					lastY = cNode[1];
					
					break;
				}
			}
			
		}
		
		
		return back;
	}
}
