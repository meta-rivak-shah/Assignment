package dsa.assignment3;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the methods of PriorityQueueImplementation class
 * @author Rivak shah
 */
public class PriorityQueueImplementionTest {
	
	PriorityQueueImplementation priorityQueue = new PriorityQueueImplementation(10);
	
	@Before
	public void initialize()
	{
		priorityQueue.enqueue(new Job("Job 1", 21));
		priorityQueue.enqueue(new Job("Job 2", 30));
		priorityQueue.enqueue(new Job("Job 3", 20));
		priorityQueue.enqueue(new Job("Job 4", 10));
		priorityQueue.enqueue(new Job("Job 5", 9));
		priorityQueue.enqueue(new Job("Job 6", 52));
		priorityQueue.enqueue(new Job("Job 7", 14));
		priorityQueue.enqueue(new Job("Job 8", 3));
		priorityQueue.enqueue(new Job("Job 9", 8));
		priorityQueue.enqueue(new Job("Job 10", 1));
	}
	
	@Test
	public void testDequeue1()
	{
		assertEquals("Job 6", priorityQueue.dequeue().getJobName());
		assertEquals("Job 2", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
	}
	
	@Test(expected = AssertionError.class)
	public void testDequeue2()
	{
		assertEquals("Job 6", priorityQueue.dequeue().getJobName());
		assertEquals("Job 2", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
		assertEquals("Job 1", priorityQueue.dequeue().getJobName());
	}
	
	@Test(expected = AssertionError.class)
	public void testEnqueue()
	{
		priorityQueue.enqueue(new Job("Job 11", 15));
	}

}
