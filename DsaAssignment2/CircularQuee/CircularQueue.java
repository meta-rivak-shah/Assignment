package com.metacube.get2019;

/**
 * It is a class used to implement a circular queue using array.
 * @author Rivak
 *
 */
public class CircularQueue implements Queue{

	int size;
	int queueArr[] = new int[40];
	int count  = 0;
	int rear, front;
	
	/**
	 * It is an constructor used to intialize size of the circular queue.
	 * @param size size of the queue.
	 */
	CircularQueue(int size) {
		this.size = size;
		rear = 0;
		front = 0;
	}
	
	
	/**
	 * It is a method used to check whether circular queue is empty or not.
	 * @return boolean value.
	 */
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;
	}
	
	/**
	 * It is method used to check whether queue is full or not.
	 * @return boolean value
	 */
	public boolean isFull() {
		rear = (rear + 1) % size;
		if (front == rear) {
			if (rear == 0) {
				rear = size - 1;
			}
			else {
				rear = rear - 1;
			}
			return true;
		}
		rear = rear - 1;
		return false;
	}
	
	/**
	 * It is a method to insert an element into the circular queue.
	 * @param data element to be inserted.
	 */
	public void enqueue(int data) {
		if(!isFull()) {
			 
			queueArr[rear] = data;
		}
		else {
			System.out.println("Queue is full!!!");
		}
	}
	
	/**
	 * It is a method used to delete an element from the queue.
	 * @return deleted element
	 */
	public int dequeue() {
		if(!isEmpty()) {
			front = (front + 1) % size;
			int item = queueArr[front];
			return item;		
		}
		else {
			System.out.println("Queue is empty!!!");
			return  -1;
		}
	}
	
	/**
	 * It is method used to show elements of the queue.
	 */
	public void show() {
		System.out.println("--------------------------");
			for (int i = 0; i < size; i++) {
				System.out.print("| "+queueArr[i] + " ");
			}
		System.out.println("\n--------------------------");
	}
	
	public int isSize(){
		return this.size
	}
	
}
