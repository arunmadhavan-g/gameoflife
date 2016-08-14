package exercise.gameoflife.util;
public class DoubleDimentionalArrayUtil {

	@SafeVarargs
	public static <T> void alterRow(T[][] array, int row, int offset, T ...elements) {
		for(int i=offset, j=0;j<elements.length;i++, j++){
			array[row][i] = elements[j];
		}
	}
	
	

}
