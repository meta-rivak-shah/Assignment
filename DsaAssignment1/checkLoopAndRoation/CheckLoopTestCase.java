package get2019.dsa.assignment1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CheckLoopTestCase {
	boolean expectedData = true;

	@Test
	public void TestRotation2() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		LinkedList list = new LinkedList();
		Node head = list.insert1(data);
		head.next.next.next.next = head.next.next.next;
		boolean result = list.checkLoop(head);
		assertEquals(expectedData, result);
	}

	@Test
	public void TestRotation3() {
		boolean expectedData = false;
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		LinkedList list = new LinkedList();
		Node head = list.insert1(data);
		boolean result = list.checkLoop(head);
		assertEquals(expectedData, result);
	}

}