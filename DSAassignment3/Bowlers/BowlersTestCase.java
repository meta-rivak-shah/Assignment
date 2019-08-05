package dsa.assignment3;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the methods of PriorityQueueImplementation class
 * @author Rivak shah
 */
public class BowlersTestCase {
	
	PriorityQueueImplementation priorityQueue = new PriorityQueueImplementation(10);
	
	@Before
	public void initialize()
	{
		maxHeap maxHeap = new maxHeap(15);
		maxHeap maxHeap2 = new maxHeap(15);
	}
	
	@Test
	public void testOrder1()
	{
		ArrayList<Bowlers> Bolwers1 = new ArrayList<Bowlers>();
		Bolwers1.add(new Bowlers("a1" , 4));
		Bolwers1.add(new Bowlers("b1" , 2));
		Bolwers1.add(new Bowlers("c2" , 1));
		for (int i = 0; i < Bolwers1.size(); i++) {
			maxHeap.add(Bolwers1.get(i));
		}
		assertEquals("new int[]{4,3,2,2,1,1,1}", maxHeap.getOrders());
	}

	public void testOrder2()
	{
		ArrayList<Bowlers> Bolwers1 = new ArrayList<Bowlers>();
		Bolwers1.add(new Bowlers("a1" , 3));
		Bolwers1.add(new Bowlers("b1" , 2));
		Bolwers1.add(new Bowlers("c2" , 1));
		for (int i = 0; i < Bolwers1.size(); i++) {
			maxHeap.add(Bolwers1.get(i));
		}
		assertEquals("new int[]{3,2,2,1,1,1}", maxHeap2.getOrders());
	}



}
