package get2019.assignment4;
/**
 * @class SearchAlgo have following operation like 
 * @func linearSearch
 * @func binarySearch
 * @func searchIndex
 * @param flag is used to check some start test value
 * @param size contain the size of array
 * @author Rivak
 */
public class SearchAlgo {
	private int flag = 0;
	private int size = 0;

	/*this function can find element in array if it exit or not
	 * @param Array[] this contain the element
	 * @param value this contain the value which want to search
	 * @return -1 if no element is found
	 * @return index of element if found
	 */
	int linearSearch(int Array[], int value) {
		if (flag == 0) {
			size = Array.length - 1;
			flag = 1;
		}
		if (size == -1) {
			return -1;
		} else if (Array[size] == value) {
			//check array is present that index
			return size;
		} else {
			size = size - 1;
			return linearSearch(Array, value); //Recursion call until element is not found
		}
	}
	
	/*this function check every element and if the element exit it return 1 or -1
	 * we are assuming the array element is sorted
	 * it divide the array by 2 and check find value is greater then middle and less then middle 
	 * then move to that side
	 * @return -1 if array element is not found;
	 * @return index if array element is found
	 */
	int binarySearch(int Array[], int value) {
		int left = 0;
		int right = Array.length;
		int result = searchIndex(Array, value, left, right);
		return result;
	}

	private int searchIndex(int[] array, int value, int left, int right) {
		
		//until right is greater then left 
		while (left < right) {
			int mid = (right + left) / 2;
			//if array element is at mid then return index
			if (array[mid] == value) {
				return mid;
			}
			//if array element is greater then value
			if (array[mid] > value) {
				return searchIndex(array, value, left, right - 1); //recursion until element is not found at every call decreases the value of right by 1
			}
			//if array element is less then value
			if (array[mid] < value) {
				return searchIndex(array, value, left + 1, right); //recursion until element is not found at every call increases the value of right by 1
			}
		}
		return -1;
	}

}
