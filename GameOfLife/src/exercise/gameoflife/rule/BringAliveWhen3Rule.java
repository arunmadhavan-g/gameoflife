package exercise.gameoflife.rule;

import exercise.gameoflife.Cell;

public class BringAliveWhen3Rule implements Rule {

	@Override
	public Cell apply(Cell cell, int adjacentLiveCellCount) {
		if(adjacentLiveCellCount == 3){
			return new Cell(true);
		}
		return new Cell(cell);
	}

}
