import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.google.common.collect.Lists;

import exercise.gameoflife.Cell;
import exercise.gameoflife.rule.BringAliveWhen3Rule;
import exercise.gameoflife.rule.LonelyRule;
import exercise.gameoflife.rule.OverCrowdRule;

public class CellSpec {

	@Test
	public void cellAlive() {
		Cell cell = new Cell(true);
		assertThat(cell.isAlive()).isTrue();
	}

	@Test
	public void cellDead() throws Exception {
		Cell cell = new Cell(false);
		assertThat(cell.isAlive()).isFalse();
	}
	
	@Test
	public void killCell() throws Exception {
		
		//Given
		Cell cell = new Cell(true);
		//When
		Cell deadCell  = cell.kill();
		//Then
		assertThat(deadCell.isAlive()).isFalse();
	}

	@Test
	public void bringCellAlive() throws Exception {
		Cell cell = new Cell(false);
		Cell liveCell = cell.live();
		assertThat(liveCell.isAlive()).isTrue();
	}
	
	
	@Test
	public void applyRules() throws Exception {
		
		//Given
		Cell cell = new Cell(true);
		//When
		Cell modifiedCell = cell.applyRules(Lists.newArrayList(new LonelyRule(), new OverCrowdRule(), new BringAliveWhen3Rule()), 4);
		//Then
		assertThat(modifiedCell).isEqualTo(new Cell(false));
	}
	
}
