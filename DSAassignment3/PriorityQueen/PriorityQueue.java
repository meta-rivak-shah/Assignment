
package dsa.assignment3;
/**
 * Interface of Priority Queue consisting declarations of methods that are to be implemented
 * @author Rivak shah
 */
public interface PriorityQueue {

	/**
	 * This method inserts an value to the queue
	 * @param value to be added to the queue
	 * @return {boolean} true if value is added else false
	 */
	public void enqueue(Job job) ;

	/**
	 * This method removes a value from the queue
	 * @return {Job} removed value
	 */
	public Job dequeue();

	/**
	 * This method checks whether the queue is empty or not
	 * @return {boolean}
	 */
	public boolean isEmpty() ;

	/**
	 * This method checks whether the queue is full or not
	 * @return {boolean}
	 */
	public boolean isFull() ;
}