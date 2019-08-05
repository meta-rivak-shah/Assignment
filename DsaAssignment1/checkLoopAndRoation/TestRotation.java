package get2019.dsa.assignment1;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestRotation {
	int[] data = { 2, 3, 4, 5, 6, 7, 8 };
	int[] expectedData = { 2, 5, 6, 3, 4, 7 };

	@Test
	public void TestRotation1() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		LinkedList list = new LinkedList();
		Node head = list.insert1(data);
		int[] result = list.rotateList(head, 2, 5, 2, data.length);
		int[] expectedData = { 2, 3, 4, 5, 6, 7, 8 };
		assertArrayEquals(expectedData, result);
	}

	@Test
	public void TestRotation2() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		LinkedList list = new LinkedList();
		Node head = list.insert1(data);
		int[] result = list.rotateList(head, 7, 7, 2, data.length);
		int[] expectedData = {};
		assertArrayEquals(expectedData, result);
	}

	@Test
	public void TestRotation3() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		LinkedList list = new LinkedList();
		Node head = list.insert1(data);
		int[] result = list.rotateList(head, 7, 8, 2, data.length);
		int[] expectedData = {};
		assertArrayEquals(expectedData, result);
	}

	@Test
	public void TestRotation4() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		LinkedList list = new LinkedList();
		Node head = list.insert1(data);
		int[] result = list.rotateList(head, 6, 8, 2, data.length);
		int[] expectedData = {};
		assertArrayEquals(expectedData, result);
	}

	@Test
	public void TestRotation6() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		LinkedList list = new LinkedList();
		Node head = list.insert1(data);
		int[] result = list.rotateList(head, 1, 7, 2, data.length);
		int[] expectedData = { 2, 5, 6, 7, 3, 4, 8 };
		assertArrayEquals(expectedData, result);
	}

	@Test
	public void TestRotation5() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		LinkedList list = new LinkedList();
		Node head = list.insert1(data);
		int[] result = list.rotateList(head, 8, 8, 2, data.length);
		int[] expectedData = {};
		assertArrayEquals(expectedData, result);
	}
}