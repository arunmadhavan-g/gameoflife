package exercise.gameoflife.rule;
import exercise.gameoflife.Cell;

public class LonelyRule implements Rule{

	@Override
	public Cell apply(Cell cell, int adjacentLiveCellCount) {
		if(adjacentLiveCellCount < 2)
			return cell.kill();
		
		return new Cell(cell);
	}

}
