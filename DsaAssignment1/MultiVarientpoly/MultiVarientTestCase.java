package get2019.dsa.assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiVarientTestCase {
	@Test
	public void TestRotation1() {
		int expectedData = 11;
		MultiVarient MultiVarient = new MultiVarient();
		PolyNode p1 = null;
		if (MultiVarient.head == null) {
			p1 = MultiVarient.insert();
			p1.next = new Node1(2, "x", 3);
			MultiVarient.head = p1;
		}
		p1.next.Next = new Node1(1, "y", 3);
		p1.next.Next.Next = new Node1(1, "z", 3);
		p1.nextPolyNode = MultiVarient.insert();
		p1.nextPolyNode.next = new Node1(1, "y", 3);
		p1.nextPolyNode.next.Next = new Node1(1, "z", 4);
		p1.nextPolyNode.next.Next.Next = new Node1(1, "u", 4);
		MultiVarient.printList(p1);
		int max = MultiVarient.findDegree(p1);
		System.out.println();
		System.out.println("Maximum Degree is->" + max);
		assertEquals(expectedData, max);
	}

	@Test
	public void TestRotation3() {
		int expectedData = 30;
		MultiVarient MultiVarient = new MultiVarient();
		PolyNode p1 = null;
		if (MultiVarient.head == null) {
			p1 = MultiVarient.insert();
			p1.next = new Node1(2, "x", 4);
			MultiVarient.head = p1;
		}
		p1.next.Next = new Node1(1, "y", 3);
		p1.next.Next.Next = new Node1(1, "z", 3);
		p1.nextPolyNode = MultiVarient.insert();
		p1.nextPolyNode.next = new Node1(1, "y", 3);
		p1.nextPolyNode.next.Next = new Node1(1, "z", 4);
		p1.nextPolyNode.next.Next.Next = new Node1(1, "u", 4);
		p1.nextPolyNode.nextPolyNode = MultiVarient.insert();
		p1.nextPolyNode.nextPolyNode.next = new Node1(1, "y", 10);
		p1.nextPolyNode.nextPolyNode.next.Next = new Node1(1, "z", 10);
		p1.nextPolyNode.nextPolyNode.next.Next.Next = new Node1(1, "u", 10);
		MultiVarient.printList(p1);
		int max = MultiVarient.findDegree(p1);
		System.out.println();
		System.out.println("Maximum Degree is->" + max);
		assertEquals(expectedData, max);
	}

	@Test
	public void TestRotation2() {
		int expectedData = 0;
		MultiVarient MultiVarient = new MultiVarient();
		PolyNode p1 = null;
		int max = MultiVarient.findDegree(p1);
		System.out.println();
		System.out.println("Maximum Degree is->" + max);
		assertEquals(expectedData, max);
	}

}