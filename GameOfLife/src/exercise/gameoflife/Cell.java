package exercise.gameoflife;
import java.util.List;

import exercise.gameoflife.rule.Rule;

public class Cell {
	private boolean alive;

	public Cell(boolean alive) {
		this.alive = alive;
 	}
	
	public Cell(Cell cell) {
		this.alive= cell.alive;
	}

	public boolean isAlive() {
		return alive;
	}

	public Cell kill() {
		return new Cell(false);
	}

	public Cell live() {
		return new Cell(true);
	} 
	
	@Override
	public String toString() {
		return alive?"X":"-";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null){
			Cell that = (Cell)obj;
			return that.alive ==  this.alive;
		}
		return false;
	}

	public Cell applyRules(List<Rule> rules, int countOFLiveCells) {
		return applyRule(this, rules.get(0), countOFLiveCells, rules.subList(1, rules.size()));
	}
	
	public Cell applyRule(Cell cell, Rule rule, int countOfLiveCells, List<Rule> rules){
		if(rules.isEmpty()){
			return rule.apply(cell, countOfLiveCells);
		}
		return applyRule(rule.apply(cell, countOfLiveCells), rules.get(0), countOfLiveCells, rules.subList(1, rules.size()));
	}
	
}
