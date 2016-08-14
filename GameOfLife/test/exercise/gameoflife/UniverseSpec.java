package exercise.gameoflife;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import exercise.gameoflife.Universe;
import exercise.gameoflife.rule.BringAliveWhen3Rule;
import exercise.gameoflife.rule.Rule;
import exercise.gameoflife.rule.LonelyRule;
import exercise.gameoflife.rule.OverCrowdedRule;

public class UniverseSpec {

	private List<Rule> rulesList = Lists.newArrayList(new LonelyRule(), new OverCrowdedRule(), new BringAliveWhen3Rule());
	
	@Test
	public void construct2X2UniverseWithAllCellsAlive() throws Exception {
		// Given
		Universe universe = new Universe(2, 2);
		// When
		Universe newUniverse = universe.seed(1, true, true)
										.seed(2, true, true);
		// Then
		assertThat(newUniverse.toString()).isEqualTo("- - - - \n- X X - \n- X X - \n- - - - \n");
	}
	
	@Test
	public void construct2X2UninitializedUniverseAndShowAllCellsAreDead() throws Exception {
		//Given
		Universe universe = new Universe(2, 2);
		//When
		//Then
		assertThat(universe.toString()).isEqualTo("- - - - \n- - - - \n- - - - \n- - - - \n");
	}
	
	@Test
	public void checkCountFor3X2Universe() throws Exception {
		
		//Given
		Universe universe = new Universe(3, 2)
				.seed(1, true, true)
				.seed(2, true, true)
				.seed(3, true, true);
		//When
		int count = universe.countAdjacentAliveCells(2, 1);
		//Then
		assertThat(count).isEqualTo(5);
	}
	
	@Test
	public void countNumberOfCellsAliveAroundForAGivenCell() throws Exception {
		//Given
		int row = 1;
		int column = 1;
		Universe universe = new Universe(2, 2)
				.seed(1, true, true)
				.seed(2, true, true);
		//When
		int numberOfCellsAliveAround =  universe.countAdjacentAliveCells(row, column);
		//Then
		assertThat(numberOfCellsAliveAround).isEqualTo(3);
	}
	
	@Test
	public void blockPattern() throws Exception {
		
		//Given
		Universe universe = new Universe(2, 2)
								.seed(1,true, true)
								.seed(2,  true, true);
		//When
		Universe newUniverse = universe.applyRules(rulesList);
		//Then
		assertThat(newUniverse.toString()).isEqualTo(new Universe(2, 2)
															.seed(1,true, true)
															.seed(2,  true, true).toString());
	}
	
	
	@Test
	public void boatPattern() throws Exception {
		Universe universe = new Universe(3, 3)
								.seed(1,true,true, false)
								.seed(2, true, false, true)
								.seed(3, false , true, false);
		
		Universe newUniverse = universe.applyRules(rulesList);
		
		assertThat(newUniverse.toString()).isEqualTo(new Universe(3,3)
														.seed(1,true,true, false)
														.seed(2, true, false, true)
														.seed(3, false , true, false).toString());
	}
	
	
	@Test
	public void blinkerPattern() throws Exception {
		Universe universe = new Universe(3,3)
								.seed(1, "-", "X", "-")
								.seed(2, "-", "X", "-")
								.seed(3, "-", "X", "-");
		
		Universe newUniverse = universe.applyRules(rulesList);
		
		assertThat(newUniverse.toString()).isEqualTo(new Universe(3, 3)
														.seed(1, false, false, false)
														.seed(2, true, true, true)
														.seed(3,  false, false, false).toString());
	}
	
	@Test
	public void toadPattern() throws Exception {
		
		//Given
		Universe universe = new Universe(2, 4)
								.seed(1, "-","X","X","X")
								.seed(2, "X","X","X","-");
		//When
		Universe newUniverse = universe.applyRules(rulesList);
		//Then
		assertThat(newUniverse.toString()).isEqualTo(new Universe(4,4)
															.seed(1,false, false, true, false)
															.seed(2, true, false, false, true)
															.seed(3, true, false, false, true)
															.seed(4, false, true, false, false).toString());
	}
	
	
	
}
