package dsa.assignment2;

import java.util.ArrayList;

/**
 * @author rivakshah this class is used to find how capction give bowls to
 *         bowlers that kholi get low run
 */
class maxHeap

{
	private int maxSize;
	private Bowlers[] heap;
	private int size;

	/**
	 * Constructor to initialize the data members of the class
	 * 
	 * @param maxSize is the capacity of the queue
	 */
	maxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.heap = new Bowlers[this.maxSize + 1];
		this.size = 0;
		this.heap[0] = new Bowlers("z", Integer.MAX_VALUE);
	}

	/**
	 * Returns the parent of the bowler at position
	 * 
	 * @param position is the element's position whose parent is to be determined
	 * @return {int} position of the parent
	 */
	int getParent(int pos) {
		return pos / 2;
	}

	/**
	 * Returns the left child of the bowler at position
	 * 
	 * @param position is the element's position whose left child is to be
	 *                 determined
	 * @return {int} position of the left child
	 */
	int getLeft(int pos) {
		return pos * 2;
	}

	/**
	 * Returns the right child of the bowler at position
	 * 
	 * @param position is the element's position whose right child is to be
	 *                 determined
	 * @return {int} position of the right child
	 */
	int getRight(int pos) {
		return (pos * 2) + 1;
	}

	/**
	 * This method swaps the values the bowlersList array at two positions
	 * 
	 * @param position1 is the first position
	 * @param position2 is the second position
	 */
	void swap(int pos1, int pos2) {
		Bowlers temp = this.heap[pos1];
		this.heap[pos1] = this.heap[pos2];
		this.heap[pos2] = temp;
		return;
	}

	/**
	 * the add method is used to add the bowlers and the total no of bowls
	 * 
	 * @param bowlers is Bowlers which contain bowlers object add into the heap
	 */
	void add(Bowlers bowlers) {
		this.heap[++this.size] = bowlers;
		int curr = this.size;

		while (this.heap[curr].bowl >= this.heap[getParent(curr)].bowl) {
			swap(curr, getParent(curr));
			curr = getParent(curr);
		}
	}

	/**
	 * This method heapifies the heap at a particular position
	 * 
	 * @param position is the position at which heapify is to be performed
	 */
	private void maxHeapify(int pos) {
		if (isLeaf(pos)) {
			return;
		}

		if (heap[pos].bowl < heap[getLeft(pos)].bowl || heap[pos].bowl < heap[getRight(pos)].bowl) {

			if (heap[getLeft(pos)].bowl > heap[getRight(pos)].bowl) {
				swap(pos, getLeft(pos));
				pos = getLeft(pos);
				maxHeapify(pos);
			}

			else {

				swap(pos, getRight(pos));
				pos = getRight(pos);
				maxHeapify(pos);
			}
		}
	}

	/**
	 * This method checks whether an element is at leaf of the heap or not
	 * 
	 * @param position is the element's position which is to be checked
	 * @return {boolean}
	 */
	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	/**
	 * this fuucntion is used to delete the bowlers form heap
	 * 
	 * @return targetData; which is the first max value of heap
	 */
	Bowlers delete() {
		Bowlers targetData = this.heap[1];
		System.out.println(size);
		this.heap[1] = this.heap[size--];
		int curr = 1;
		maxHeapify(curr);
		return targetData;
	}

	/**
	* function is used ot get the order how batsame are doing bowl
	*@return  function is return the array type integer which contain 
	*all order of bowl
	**/
	public  int[] getOrders() {
		maxHeap maxHeap = new maxHeap(15);
		ArrayList<Bowlers> Bolwers1 = new ArrayList<Bowlers>();
		Bolwers1.add(new Bowlers("a1" , 4));
		Bolwers1.add(new Bowlers("b1" , 2));
		Bolwers1.add(new Bowlers("c2" , 1));
		for (int i = 0; i < Bolwers1.size(); i++) {
			maxHeap.add(Bolwers1.get(i));
		}
		int BolwersOrders[Bolwers1.size()];
		Bowlers top = maxHeap.delete();
		while(top.bowl != 0) {
			BolwersOrders.add(top.bowl);
			top.bowl = top.bowl-1;
			if(top.bowl != 0) {
				maxHeap.add(top);
				top = maxHeap.delete();
			}
			else
			{
				top = maxHeap.delete();
			}
		}
	

		return BolwersOrders;
	}
}
