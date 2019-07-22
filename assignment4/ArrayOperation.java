package gate2019.assignment4;
/**
 * @class ArrayOperation this class contain all operation like
 * @func maxMirror
 * @func linearSearch
 * @func countClumps
 * @func countClumps
 * @func splitArray this class do all this basic operation
 * @author Rivak shah
 */
public class ArrayOperation {
	/**
	 * this function is used to find the mirror element in array
	 * 
	 * @eg {1,2,3,4,6,4,3,2,1} mirror element 9
	 * @param inputArray
	 * @return
	 */
	public int maxMirror(int inputArray[]) {
		int arrayElement;
		int startIndex;
		int linearSearchResult;
		int sectionCheck[] = new int[inputArray.length];
		/**
		 * try catch block is used to handle the error that if Array is empty
		 * theb it return an assertion Error
		 */
		try {
			if ( inputArray.length == 0 ) {
				throw new AssertionError("Assertion Error occured");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		/*
		 * @param inputArray contain the Array Element in this
		 * @param counter is used to increase or decreases the value one by one
		 * @param startIndex this contain the start index of left side valu
		 * @param arrayElement this is used to contain the index wise element inarray
		 * @func linearSearch this function is used to search the value in array
		 * @param result this contain the result of function
		 */
		for (int i = inputArray.length - 1; i >= 0; i--) {
			arrayElement = inputArray[inputArray.length - 1 - i];
			int counter;
			startIndex = (inputArray.length - 1) - i;
			linearSearchResult = (inputArray.length);
			while (linearSearchResult != -1) {
				int result = 1;
				counter = 1;
				linearSearchResult = linearSearch(arrayElement, startIndex,
						linearSearchResult - 1, inputArray);
				if (linearSearchResult != -1) {
					for (int j = linearSearchResult; j >= startIndex; j--) {
						// this condition check if counter is more then array
						// length of less then array length then it exit
						if ((linearSearchResult - counter) != -1&& (startIndex + counter) < inputArray.length) {
							// if both back side and front side element are
							// match then increse result and counter to search
							// more
							if (inputArray[startIndex + counter] == inputArray[linearSearchResult- counter]) {
								result = result + 1;
								counter = counter + 1;
							} else {
								// if the result is fail then store value in
								// array and make result to 0
								sectionCheck[startIndex] = result;
								result = 0;
								break;
							}
						} else {
							sectionCheck[startIndex] = result;
							result = 0;
							break;
						}
					}
				}
			}

		}

		/*
		 * this operation find the maximum number in array to find answer
		 */
		int max = sectionCheck[0];
		for (int i = 0; i < sectionCheck.length; i++) {
			if (max < sectionCheck[i]) {
				max = sectionCheck[i];
			}
		}
		return max;
	}
	/*
	 * this function is used to find the element in array
	 * @param value contain the the value which want to search
	 * @param first is start index of array
	 * @param, last is the last index of array
	 * @pram inputArray is contain the element
	 */
	private int linearSearch(int value, int first, int last, int[] inputArray) {
		for (int i = last; i > first; i--) {
			if (inputArray[i] == value) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * @param inputArray  contain the element in the array
	 * @return the -1 or no of clumps if two adjacent are match
	 * @param index  is used to store the same element is there or not
	 * @param count  this parameter is used store the number of clumps
	 */
	public int countClumps(int[] inputArray) {
		int count = 0;
		int index = -1;
		for (int i = 1; i <= inputArray.length - 1; i++) {
			if (inputArray[i - 1] == inputArray[i]) {
				if (index == inputArray[i]) {
					index = inputArray[i - 1];
					continue;
				} else {
					count = count + 1;
					index = inputArray[i - 1];
				}
			} else {
				index = inputArray[i - 1];
			}
		}
		return count;
	}
	/**
	 * @param sumOfArray  complete sum of array
	 * @param rideSideSum is the sum of ride side
	 * @param inputArray  contain all the array element
	 * @return
	 */
	public int splitArray(int[] inputArray) {
		int sumOfArray = 0;
		int righSideSum = 0;
		int totalAdjacent = 0;
		for (int i = 0; i < inputArray.length; i++) {
			sumOfArray = sumOfArray + inputArray[i];
		}
		if (sumOfArray % 2 == 1) {
			return -1;
		} else {
			int halfSum = (sumOfArray / 2);
			// unitl half sum is not equal is ride sum and sum of array is
			// greter then 0
			while (halfSum != righSideSum && sumOfArray > 0) {
				righSideSum = sumOfArray - inputArray[totalAdjacent];
				sumOfArray = sumOfArray - inputArray[totalAdjacent];
				totalAdjacent = totalAdjacent + 1;
			}
			if (totalAdjacent == inputArray.length) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	/**
	 * @param inputArray   contain the element of array
	 * @param x element which should not move
	 * @param y  element which next to x element
	 * @return the modified array
	 */
	public int[] fixXY(int[] inputArray, int x, int y) {
		// 1, 4, 1, 5, 5, 4,
		int i = 0;
		int k;
		int countX = 0;
		int countY = 0;
		try {
			if (inputArray.length == 0) {
				throw new AssertionError("Assertion Error occured");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		for (int l = 0; l < inputArray.length; l++) {
			if (inputArray[l] == x) {
				countX = countX + 1;
			} else if (inputArray[l] == y) {
				countY = countY + 1;
			}
		}
		try {
			if (countX != countY) {
				throw new AssertionError("Assertion Error occured");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		for (int l = 1; l < inputArray.length; l++) {
			try {
				if (inputArray[l - 1] == x && inputArray[l] == y) {
					throw new AssertionError("Assertion Error occured");
				}

			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			}
		}
		try {
			if (inputArray[inputArray.length - 1] == x) {
				throw new AssertionError("Assertion Error occured");
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		int[] ArrayOfY = new int[inputArray.length];
		for (int j = 0; j < inputArray.length; j++) {
			if (inputArray[j] == y) {
				ArrayOfY[i] = j;
				i = i + 1;
			} else {
				ArrayOfY[i] = -1;
				i = i + 1;
			}

		}
		int i1 = 0;
		for (i1 = 0; i1 < inputArray.length; i1++) {
			if (inputArray[i1] == x) {
				if (i1 < inputArray.length - 1) {
					for (k = 0; k < ArrayOfY.length; k++) {
						if (ArrayOfY[k] != -1) {
							int temp = inputArray[i1 + 1];
							inputArray[i1 + 1] = inputArray[ArrayOfY[k]];
							inputArray[ArrayOfY[k]] = temp;
							ArrayOfY[k] = -1;
							break;
						}
					}
				}
			}

		}
		return inputArray;
	}

}
