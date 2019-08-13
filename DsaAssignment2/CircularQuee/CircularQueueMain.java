package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CircularQueueMain {
 
	public static void main(String args[]) {
		boolean isExit = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.print("Enter the size of queue : ");
		int size = sc.nextInt();
		System.out.println("-------------------------");
		CircularQueue queueObj = new CircularQueue(size);
		try {
			do {
				System.out.println("-------------------------");
				System.out.println("1. Insert an element into the queue.");
				System.out.println("2. Delete an element into the queue.");
				System.out.println("3. Check queue is full or not.");
				System.out.println("4. Check queue is empty or not.");
				System.out.println("5. Show the items of the queue.");
				System.out.println("6. Exit");
				System.out.println("-------------------------");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				System.out.println("-------------------------");
				switch (choice) {
				case 1 :
					System.out.print("Enter the data item which u want to insert into the queue : ");
					int data = sc.nextInt();
					System.out.println("-------------------------");
					queueObj.enqueue(data);
					break;
				case 2 :
					int item = queueObj.dequeue();
					System.out.println("Deleted element is : "+item);
					System.out.println("-------------------------");
					break;
				case 3 :
					boolean isFull = queueObj.isFull();
					System.out.println("Queue is full : "+isFull);
					System.out.println("-------------------------");
					break;
				case 4 :
					boolean isEmpty = queueObj.isEmpty();
					System.out.println("Queue is empty  : "+isEmpty);
					System.out.println("-------------------------");
					break;
				case 5:
					queueObj.show();
					break;
				case 6:
					isExit = true;
					System.out.println("Successfully exit!!!");
					System.out.println("-------------------------");
					break;
				default :
					System.out.println("Invalid choice!!");
					System.out.println("-------------------------");
				}
			}while (!isExit);
		}catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}
		finally {
			sc.close();
		}
	}
}
