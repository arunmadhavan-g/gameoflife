package exercise.gameoflife;
import java.util.Arrays;
import java.util.List;

import exercise.gameoflife.rule.Rule;

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

	public Universe seed(int row, boolean ...isAlive) {
		for(int i=1,j=0;i<this.maxColumns-1; i++, j++){
			cells[row][i] = new Cell(isAlive[j]); 
		}
		return new Universe(this.maxRows-2, this.maxColumns-2, cells);
	}
	
	public Universe seed(int row, String ...xOrDash){
		return seed(row, liveListFromString(xOrDash));
	}
	
	private boolean[] liveListFromString(String[] xOrDash) {
		boolean[] isAliveList = new boolean[xOrDash.length];
		int position = 0;
		for(String str: xOrDash){
			isAliveList[position] = ("X").equalsIgnoreCase(str);
			position++;
		}
		return isAliveList;
	}

	public int countAdjacentAliveCells(int row, int column) {
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
 