package exercise.gameoflife;
import java.util.List;

import exercise.gameoflife.rule.Rule;
import exercise.gameoflife.util.DoubleDimentionalArrayUtil;
import exercise.gameoflife.util.UniverseHelper;

public class Universe {
	
	private Cell[][] cells;
	private final  int maxRows;
	private final int maxColumns;
	
	public Universe(int rows, int columns) {
		this.maxRows = rows+2;
		this.maxColumns = columns+2;
		cells = new Cell[maxRows][maxColumns];
		DoubleDimentionalArrayUtil.initialize(cells, new Cell(false));
	}

	public Universe(int rows, int columns, Cell[][] cells) {
		this.maxRows = rows+2;
		this.maxColumns = columns+2;
		this.cells = cells;
	}

	public Universe seed(int row, Cell ...rowCells){
		DoubleDimentionalArrayUtil.alterRow(this.cells, row, 1,  rowCells);
		return new Universe(this.maxRows-2, this.maxColumns-2, this.cells);
	}
	public Universe seed(int row, boolean ...isAlive) {
		return seed(row, UniverseHelper.booleanToCells(isAlive));
	}
	
	public Universe seed(int row, String ...xOrDash){
		return seed(row, UniverseHelper.stringToCells(xOrDash));
	}
	

	int countAdjacentAliveCells(int row, int column) {
		int count = 0;
		for(int i=row-1; i<= row+1; i++){
			if(i>=0 && i<this.maxRows){
				for(int j=column-1; j<= column+1;j++){
					if(j>=0 && j< this.maxColumns){
						if(!(i==row && j== column)){
							if(this.cells[i][j].isAlive())
								count++;
						}
					}
				}
			}
		}
		return count;
	}

	public Universe applyRules(List<Rule> rules) {
		Cell[][] newCells = new Cell[maxRows][maxColumns];
		for(int i=0;i<maxRows ;i++){
			for(int j=0;j<maxColumns; j++){
				newCells[i][j] = cells[i][j].applyRules(rules, countAdjacentAliveCells(i, j));
			}
		}
		return new Universe(maxRows-2, maxColumns-2, newCells);
	}
	
	@Override
	public String toString() {
		StringBuffer buff =  new StringBuffer();
		Cell[][] cells = DoubleDimentionalArrayUtil.trim(this.cells, Cell.class, new Cell(false));
		
		for(int i=0;i<cells.length; i++){
			for(int j=0;j<cells[0].length; j++){
				buff.append(cells[i][j]).append(" ");
			}
			buff.append("\n");
		}
		return buff.toString();
	}
	
}
 