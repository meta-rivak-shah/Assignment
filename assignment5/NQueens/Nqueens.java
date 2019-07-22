package get2019.assignment4;
/**
 * @class Nqueens have following function 
 * @func safeSearch
 * @func insertQ
 * @func printElement
 * this class can insert the queen at every position and return the complete chess board
 * @author Rivak
 *
 */
public class Nqueens {
	/**
	 * 
	 * @param intputArray contain complete element
	 * @param i contain index of row
	 * @param j contain index of column
	 * @return false if queen have not position to insert or true if insert
	 */
	boolean safeSearch(int intputArray[][], int i, int j) {
		//in this function we are checking the left side of column of same row 
		//if any queen is there it will return false else return true;
		for (int col = j; col >= 0; col--) {
			if (intputArray[i][col] == 1) {
				return false;
			}
		}
		//in this function we are checking the top side of row of same column 
		//if any queen is there it will return false else return true;
		for (int col = i; col >= 0; col--) {
			if (intputArray[col][j] == 1) {
				return false;
			}
		}
		//in this function we are checking the top diagonal  side of row and  column 
		//if any queen is there it will return false else return true;
		int colUpper = j - 1;
		int colUpper1 = j + 1;
		for (int row = i; row >= 0; row--) {
			colUpper = colUpper + 1;
			if (colUpper < intputArray.length) {
				if (intputArray[row][colUpper] == 1) {
					return false;
				}
			}
			colUpper1 = colUpper1 - 1;
			if (colUpper1 >= 0) {
				if (intputArray[row][colUpper1] == 1) {
					return false;
				}
			}
		}
		//in this function we are checking the bottom diagonal  side of row and  column 
		//if any queen is there it will return false else return true;
		int colLower = j - 1;
		int colLower2 = j + 1;
		for (int row = i; row < intputArray.length; row++) {
			colLower = colLower + 1;
			if (colLower < intputArray.length) {
				if (intputArray[row][colLower] == 1) {
					return false;
				}
			}
			colLower2 = colLower2 - 1;
			if (colLower2 >= 0) {
				if (intputArray[row][colLower2] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private int step = 1;
	/**
	 * 
	 * @param intputArray contain element of array
	 * @param col is used as column in the function
	 * @return true if all queens are placed else false
	 */
	boolean insertQ(int intputArray[][], int col) {
		if (col == intputArray.length) {
			return true;
		}
		for (int i = 0; i < intputArray.length; i++) {
			if (safeSearch(intputArray, i, col)) {
				intputArray[i][col] = 1;
				if (!insertQ(intputArray, col + 1)) { //Backtrack  meANS IF FUNCTION RETURN FALSE IT WILL UPDATE PREVIOUS RESULT
					intputArray[i][col] = 0;
				} else {
					return true;
				}
			}
		}
		return false;
	}
	/*
	 * @param inputArray contain element in array
	 * function is used to print all element of array
	 */
	int[][] printElement(int inputArray[][]) {
		if (!insertQ(inputArray, 0)) {
			return inputArray;
		}

		return inputArray;
	}

}