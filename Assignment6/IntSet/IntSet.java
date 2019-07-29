package get2019.assignment6;
/**
 * @class IntSet Have following operation like 
 * @fun sizeOfSet
 * @fun isMember
 * @fun isSubSet
 * @fun getComplement
 * @fun getUnion
 * @param set is array type private member which can only initialize ones
 * class is In mutable and which can not inherited 
 * @author Rivak shah
 *@date 22/7/2019
 */
public final class IntSet {
	final private int set[];
	
	/**
	 * Constructor  to intialize the set array
	 * @param set this is one dimensional array
	 */
	IntSet(int set[]){
		this.set = set;
	}
	
	/*
	 * @return array value
	 */
	public int[] getSet() {
		return set;
	}
	
	/**
	 * this function is used to get the size of array
	 * @return int value 
	 */
	public int sizeOfSet() {
		int size = 0;
		for (int i = 0; i < this.getSet().length; i++) {
			size = size + 1;
		}
		return size-1;
	}
	
	/**
	 * function find the value is present in it or not
	 * @param value is any variable which is int type
	 * @return the boolean value
	 */
	public boolean isMember(int value) {
		for (int i = 0; i < this.getSet().length; i++) {
			if(value  == this.getSet()[i]){
				return true;
			}
		}
		return  false;
	}

	/**
	 * check the subset array is subset of main set
	 * @param subSet contain the element of array 
	 * @return true or false
	 */
	public boolean isSubSet(int[] subSet) {
		if (subSet.length == 0) {
			return true;//indicate the empty set
		} else {
			int count = 0;
			int jElement = this.getSet().length - 1;
			while (count != subSet.length) {

				if (subSet[count] != this.getSet()[jElement]) {
					if (jElement != 0) { // if jElement is == -1 which means set is checked 
						jElement = jElement - 1; //check every element of universal set by  the value
					} else {
						break; //break the loop if element is found 
					}
				} else {
					jElement =  this.getSet().length - 1;
					count = count + 1; //increment the value of count when element of subset is in universal set
				}
			}
			if (count == subSet.length) { //both have same length means subset is there in set
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * 
	 * @param subSet give the subset element array in function which give complement of the set
	 * the element present in the subset are remain and not present are return
	 * @return int array is return int this
	 */
	public int[] getComplement(int[] subSet) {

		int complementSet[] = new int[this.getSet().length - subSet.length];
		if (subSet.length == 0) { //if subset is empty it return complete set
			return this.getSet();
		} else {
			int count = 0; 
			int jElement = set.length - 1;
			while (count != subSet.length) {
				if (subSet[count] != set[jElement]) {
					if (jElement != -1) {// if jElement is == -1 which means set is checked 
						jElement = jElement - 1;//check every element of universal set by  the value

					}
				} else {
					set[jElement] = -1;
					jElement = set.length - 1; 
					count = count + 1;//increment the value of count when element of subset is in universal set
				}
			}
			int nElement = 0;
			for (int i = 0; i < set.length; i++) {

				if (set[i] != -1) { //if there is -1 in between the set it will leave that index else put the value
					complementSet[nElement] = set[i];
					nElement = nElement + 1;
				}
			}
		}
		
		return complementSet;
	}

	/**
	 * 
	 * @param set1 contain the set1 element in array 
	 * @param set2 contain the set2 element in array
	 * @return complete set after ADDING AND SORTING
	 */
	public int[] getUnion(IntSet intSet1, IntSet intSet2) {
		int nElement = 0;
		int kNoZero = 0;
		int unionSet[] = new int[intSet1.getSet().length + intSet2.getSet().length];
		for (int i = 0; i < intSet1.getSet().length; i++) {
			unionSet[i] = intSet1.getSet()[i];
		}
		int count = 0;
		while (intSet2.getSet().length != count) {

			if (unionSet[nElement] != intSet2.getSet()[count]) {
				nElement = nElement + 1;
				if (nElement == unionSet.length - 1) {
					unionSet[intSet1.getSet().length + count] = intSet2.getSet()[count];
					count = count + 1;
					nElement = 0;
				}
			} else {
				count = count + 1;//increment the value of count when element of subset is in universal set
				nElement = 0;
			}
		}
		for (int i = 0; i < unionSet.length; i++) {
			if (unionSet[i] != 0) {
				kNoZero = kNoZero + 1;
			}
		}
		int unionSet1[] = new int[kNoZero];
		int c = 0;
		for (int i = 0; i < unionSet.length; i++) {
			if (unionSet[i] != 0) {
				unionSet1[c] = unionSet[i];
				c++;
			}
		}
		
		return unionSet1;
	}
}
	