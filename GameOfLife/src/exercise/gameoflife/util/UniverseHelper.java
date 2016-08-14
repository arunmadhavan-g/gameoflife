package exercise.gameoflife.util;

import exercise.gameoflife.Cell;

public class UniverseHelper {

	public static Cell[] booleanToCells(boolean[] isAliveList){
		Cell[] cells = new Cell[isAliveList.length];
		int position = 0;
		for(boolean isAlive: isAliveList){
			cells[position] = new Cell(isAlive);
			position++;
		}
		return cells;
	}

	public static Cell[] stringToCells(String[] xOrDash) {
		Cell[] cells = new Cell[xOrDash.length];
		int position = 0;
		for(String str: xOrDash){
			cells[position] = new Cell(("X").equalsIgnoreCase(str));
			position++;
		}
		return cells;
	}

}
