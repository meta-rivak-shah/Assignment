package dsa.assignment3;

/**
 * This contains the implementation of priority queue using array.
 * Priority queue is implemented using heap functionality.
 * @author Rivak shah
 *
 */
public class PriorityQueueImplementation implements PriorityQueue {
	
	private Job[] jobsQueue;
	private int queueCapacity;
	private int queueSize;
	
	/**
	 * Constructor to initialize the data members of the class
	 * @param queueCapacity is the capacity of the queue
	 */
	public PriorityQueueImplementation(int queueCapacity) {
		this.queueCapacity = queueCapacity + 1;
		jobsQueue = new Job[this.queueCapacity];
		this.queueSize = 0;
	}

	/**
	 * Returns the parent of the bowler at position
	 * @param position is the element's position whose parent is to be determined
	 * @return {int} position of the parent
	 */
	int returnParent(int position) 
    { 
        return position / 2; 
    } 
	
	/**
	 * Returns the left child of the bowler at position
	 * @param position is the element's position whose left child is to be determined
	 * @return {int} position of the left child
	 */
	int returnLeftChild(int position) 
    { 
        return (2 * position); 
    } 
	
	/**
	 * Returns the right child of the bowler at position
	 * @param position is the element's position whose right child is to be determined
	 * @return {int} position of the right child
	 */
	int returnRightChild(int position) 
    { 
        return ((2 * position) + 1); 
    }
	
	/**
	 * This method checks whether an element is at leaf of the heap or not
	 * @param position is the element's position which is to be checked
	 * @return {boolean}
	 */
	boolean isLeaf(int position) 
    { 
        if (position > (this.queueSize / 2) && position <= this.queueSize) { 
            return true; 
        } 
        return false; 
    } 
	
	/**
	 * This method swaps the values the bowlersList array at two positions
	 * @param position1 is the first position
	 * @param position2 is the second position
	 */
	void swapValues(int position1, int position2)
	{
		Job temp = jobsQueue[position1];
		jobsQueue[position1] = jobsQueue[position2];
		jobsQueue[position2] = temp;
	}
	
	/**
	 * This method heapifies the heap at a particular position
	 * @param position is the position at which heapify is to be performed
	 */
	void maxHeapify(int position) 
    { 
        if (isLeaf(position)) 
            return; 
        
        if ((jobsQueue[position].getPriority() < jobsQueue[returnLeftChild(position)].getPriority()) ||  
            (jobsQueue[position].getPriority() < jobsQueue[returnRightChild(position)].getPriority())) 
        { 
            if (jobsQueue[returnLeftChild(position)].getPriority() > jobsQueue[returnRightChild(position)].getPriority()) 
            { 
                swapValues(position, returnLeftChild(position)); 
                maxHeapify(returnLeftChild(position)); 
            } 
            else 
            { 
                swapValues(position, returnRightChild(position)); 
                maxHeapify(returnRightChild(position)); 
            } 
        } 
    } 
	
	/**
	 * Overriding the enqueue method of the PriorityQueue interface to perform insertion based on the priority
	 * @param job is the job to be inserted in the priority queue
	 */
	@Override
	public void enqueue(Job job) {
		if(!isFull())
		{
			jobsQueue[++queueSize] = job; 
	        int current = queueSize; 
	        while ((current != 1) && (jobsQueue[current].getPriority() > jobsQueue[returnParent(current)].getPriority())) 
	        { 
	            swapValues(current, returnParent(current)); 
	            current = returnParent(current); 
	        }
		}
		else
			throw new AssertionError();
	}

	/**
	 * Overriding the dequeue method of the PriorityQueue interface to perform deletion in the queue based on the priority
	 * @return {Job} the deleted job
	 */
	@Override
	public Job dequeue() {
		if(!isEmpty())
		{
			Job poppedJob = jobsQueue[1]; 
	        jobsQueue[1] = jobsQueue[queueSize--]; 
	        maxHeapify(1);
	        return poppedJob; 
		}
		else
			throw new AssertionError();
	}

	/**
	 * Overriding the method to check whether the priority queue is empty
	 * @return {boolean}
	 */
	@Override
	public boolean isEmpty() {
		if(this.queueSize == 0)
			return true;
		return false;
	}

	/**
	 * Overriding the method to check whether the priority queue is full
	 * @return {boolean}
	 */
	@Override
	public boolean isFull() {
		if(this.queueSize == this.queueCapacity - 1)
			return true;
		return false;
	}

	/**
	 * This method prints the Priority Queue in the form of heap(parent leftChild rightChild)
	 */
	public void printQueue()
	{
		for(int i = 1; i <= queueSize; i++)
			System.out.println(jobsQueue[i].getJobName() + " : " + jobsQueue[i].getPriority());
	}
	