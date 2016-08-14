package exercise.gameoflife.util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DoubleDimentionalArrayUtil {

	@SafeVarargs
	public static <T> void alterRow(T[][] array, int row, int offset, T... elements) {
		for (int i = offset, j = 0; j < elements.length; i++, j++) {
			array[row][i] = elements[j];
		}
	}

	public static <T> void initialize(T[][] cells, T defaultValue) {
		for (int i = 0; i < cells.length; i++) {
			Arrays.fill(cells[i], defaultValue);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T[][] trim(T[][] cells, Class<T> type, T defaultValue) {

		int rows = cells.length;
		int columns = cells[0].length;
		
		int rowStartingIndex = rowContainsOnly(cells, 0, defaultValue)? 1: 0; 
		int columnStartingIndex = columnContainsOnly(cells, 0, defaultValue, type)? 1: 0;

		int rowEndIndex = rowContainsOnly(cells, rows-1, defaultValue)? rows -1: rows;
		int columnEndIndex = columnContainsOnly(cells, columns-1, defaultValue, type)? cells[0].length -1: cells[0].length;
		
		T[][] newArray = (T[][]) Array.newInstance(type, rowEndIndex-rowStartingIndex, columnEndIndex-columnStartingIndex);
		
		for(int i1=rowStartingIndex, i2=0; i1<rowEndIndex;i1++, i2++){
			for(int j1=columnStartingIndex, j2=0 ;j1<columnEndIndex; j1++, j2++){
				newArray[i2][j2] = cells[i1][j1]; 
			}
		}

		return newArray;
	}

	private static <T> boolean columnContainsOnly(T[][] cells, int column,  T defaultValue, Class<T> type) {
		return containsOnly(extractColumn(cells, column, type), defaultValue);
	}

	private static <T> boolean rowContainsOnly(T[][] cells, int row, T defaultValue) {
		return containsOnly(extractRow(cells, row), defaultValue);
	}

	private static <T> boolean containsOnly(T[] cells, T defaultValue) {
		for(T cell: cells){
			if(!defaultValue.equals(cell))
				return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private static <T> T[] extractColumn(T[][] cells, int column, Class<T> type) {
		T[] extractedArray = (T[]) Array.newInstance(type, cells.length);
		for(int i=0;i<cells.length;i++){
			extractedArray[i] = cells[i][column];
		}
		return extractedArray;
	}

	private static <T> T[] extractRow(T[][] cells, int row) {
		return cells[row];
	}

}
