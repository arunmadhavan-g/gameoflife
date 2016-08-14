package exercise.gameoflife;
import java.util.Arrays;
import java.util.List;

import exercise.gameoflife.rule.Rule;
import exercise.gameoflife.util.DoubleDimentionalArrayUtil;

public class Universe {
	
	private Cell[][] cells;
	private final  int maxRows;
	private final int maxColumns;
	
	public Universe(int rows, int columns) {
		this.maxRows = rows+2;
		this.maxColumns = columns+2;
		cells = new Cell[maxRows][maxColumns];
		
		for(int i=0;i<maxRows;i++){
			Arrays.fill(cells[i], new Cell(false));
		}
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
		return seed(row, booleanToCells(isAlive));
	}
	
	public Universe seed(int row, String ...xOrDash){
		return seed(row, stringToCells(xOrDash));
	}
	
	private Cell[] booleanToCells(boolean[] isAliveList){
		Cell[] cells = new Cell[isAliveList.length];
		int position = 0;
		for(boolean isAlive: isAliveList){
			cells[position] = new Cell(isAlive);
			position++;
		}
		return cells;
	}
	private Cell[] stringToCells(String[] xOrDash) {
		Cell[] cells = new Cell[xOrDash.length];
		int position = 0;
		for(String str: xOrDash){
			cells[position] = new Cell(("X").equalsIgnoreCase(str));
			position++;
		}
		return cells;
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
		for(int i=0;i<maxRows; i++){
			for(int j=0;j<maxColumns; j++){
				buff.append(cells[i][j]).append(" ");
			}
			buff.append("\n");
		}
		return buff.toString();
	}
	
}
 