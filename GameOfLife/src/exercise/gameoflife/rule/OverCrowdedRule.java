package exercise.gameoflife.rule;
import exercise.gameoflife.Cell;

public class OverCrowdedRule implements Rule {

	@Override
	public Cell apply(Cell cell, int adjacentLiveCellCount) {
		if(adjacentLiveCellCount > 3)
			return new Cell(false);
		
		return new Cell(cell);
	}

}
