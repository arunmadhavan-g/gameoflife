package exercise.gameoflife.rule;

import exercise.gameoflife.Cell;

public interface Rule {

	public Cell apply(Cell cell, int adjacentLiveCellCount);
	
}
