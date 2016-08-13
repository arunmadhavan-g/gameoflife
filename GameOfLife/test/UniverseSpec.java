import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import exercise.gameoflife.Universe;
import exercise.gameoflife.rule.BringAliveWhen3Rule;
import exercise.gameoflife.rule.Rule;
import exercise.gameoflife.rule.LonelyRule;
import exercise.gameoflife.rule.OverCrowdRule;

public class UniverseSpec {

	private List<Rule> rulesList = Lists.newArrayList(new LonelyRule(), new OverCrowdRule(), new BringAliveWhen3Rule());
	
	@Test
	public void construct2X2UniverseWithAllCellsAlive() throws Exception {
		// Given
		Universe universe = new Universe(2, 2);
		// When
		Universe newUniverse = universe.seed(0, true, true)
										.seed(1, true, false);
		// Then
		assertThat(newUniverse.toString()).isEqualTo("X X \nX - \n");
	}
	
	@Test
	public void construct2X2UninitializedUniverseAndShowAllCellsAreDead() throws Exception {
		//Given
		Universe universe = new Universe(2, 2);
		//When
		//Then
		assertThat(universe.toString()).isEqualTo("- - \n- - \n");
	}
	
	@Test
	public void checkCountFor3X3Universe() throws Exception {
		
		//Given
		Universe universe = new Universe(3, 2)
				.seed(0, true, true)
				.seed(1, true, true)
				.seed(2, true, true);
		//When
		int count = universe.countAdjacentAliveCells(1, 0);
		//Then
		assertThat(count).isEqualTo(5);
	}
	
	@Test
	public void countNumberOfCellsAliveAroundForAGivenCell() throws Exception {
		//Given
		int row = 0;
		int column = 0;
		Universe universe = new Universe(2, 2)
				.seed(0, true, true)
				.seed(1, true, true);
		//When
		int numberOfCellsAliveAround =  universe.countAdjacentAliveCells(row, column);
		//Then
		assertThat(numberOfCellsAliveAround).isEqualTo(3);
	}
	
	@Test
	public void blockPattern() throws Exception {
		
		//Given
		Universe universe = new Universe(2, 2)
								.seed(0,true, true)
								.seed(1,  true, true);
		//When
		Universe newUniverse = universe.applyRules(rulesList);
		//Then
		assertThat(newUniverse.toString()).isEqualTo(new Universe(2, 2)
															.seed(0,true, true)
															.seed(1,  true, true).toString());
	}
	
	
	@Test
	public void boatPattern() throws Exception {
		Universe universe = new Universe(3, 3)
								.seed(0,true,true, false)
								.seed(1, true, false, true)
								.seed(2, false , true, false);
		
		Universe newUniverse = universe.applyRules(rulesList);
		
		assertThat(newUniverse.toString()).isEqualTo(new Universe(3,3)
														.seed(0,true,true, false)
														.seed(1, true, false, true)
														.seed(2, false , true, false).toString());
	}
	
	
	@Test
	public void blinkerPattern() throws Exception {
		Universe universe = new Universe(3,3)
								.seed(0, "-", "X", "-")
								.seed(1, "-", "X", "-")
								.seed(2, "-", "X", "-");
		
		Universe newUniverse = universe.applyRules(rulesList);
		
		assertThat(newUniverse.toString()).isEqualTo(new Universe(3, 3)
														.seed(0, false, false, false)
														.seed(1, true, true, true)
														.seed(2,  false, false, false).toString());
	}
	
	
	
}
