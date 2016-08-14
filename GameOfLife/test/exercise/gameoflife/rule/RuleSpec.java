package exercise.gameoflife.rule;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import exercise.gameoflife.Cell;
import exercise.gameoflife.rule.BringAliveWhen3Rule;
import exercise.gameoflife.rule.Rule;
import exercise.gameoflife.rule.LonelyRule;
import exercise.gameoflife.rule.OverCrowdedRule;

public class RuleSpec {

	private final Cell deadCell = new Cell(false);
	private final Cell liveCell = new Cell(true);
	
	@Test
	public void killSpecificCellIfLonely() throws Exception {
		
		//Given
		int adjacentLiveCellCount = 1;
		Rule lonelyRule = new LonelyRule();
		//When
		Cell modifiedCell = lonelyRule.apply(liveCell, adjacentLiveCellCount );
		//Then
		assertThat(modifiedCell).isEqualTo(deadCell);
	}
	
	@Test
	public void killSpecificCellIfOverCrowded() throws Exception {
		//Given
		int adjacentLiveCellCount = 4;
		Rule overCrowdRule = new OverCrowdedRule();
		//When
		Cell modifiedCell = overCrowdRule.apply(liveCell, adjacentLiveCellCount);
		//Then
		assertThat(modifiedCell).isEqualTo(deadCell);
		
	}
	
	@Test
	public void bringAliveIfExactly3Cells() throws Exception {
		//Given
		int adjacentLiveCellCount = 3;
		Rule bringAliveWhen3Rule = new BringAliveWhen3Rule();
		//When
		Cell modifiedCell = bringAliveWhen3Rule.apply(deadCell, adjacentLiveCellCount);
		//Then
		assertThat(modifiedCell).isEqualTo(liveCell);
	}
	

}
