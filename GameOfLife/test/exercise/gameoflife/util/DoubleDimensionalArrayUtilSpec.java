package exercise.gameoflife.util;
import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;

import org.junit.Test;

import exercise.gameoflife.Cell;
import exercise.gameoflife.util.DoubleDimentionalArrayUtil;

public class DoubleDimensionalArrayUtilSpec {

	@Test
	public void alterSpecificRowAndReturnNewArray() throws Exception {
		//Given
			Cell[][] cells = new Cell[2][2];
			Arrays.fill(cells[0], new Cell(false));
			Arrays.fill(cells[1], new Cell(false));
		//When
			DoubleDimentionalArrayUtil.alterRow(cells, 1, 0, new Cell(true), new Cell(true));
		//Then
			assertThat(cells[1][0]).isEqualTo(new Cell(true));
	}
}
