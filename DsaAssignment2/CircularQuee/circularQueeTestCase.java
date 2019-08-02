package get2019.dsaAssingment2;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
* this class test the ArrayQueue operations
* @author Rivak shah
* Dated 01/08/2019
*/
public class circularQueeTestCase {
CircularQueue queue = null;
@Before
public void Initialize(){
queue = new CircularQueue(size);
}

@Test
public void testEnQueue() {
queue1 = new CircularQueue(size);
assertEquals(1,queue1.isSize());

queue2 = new CircularQueue(size);
assertEquals(2,queue2.isSize());


queue3 = new CircularQueue(size);
assertEquals(3,queue3.isSize());

}
@Test
public void testDeQueue(){

assertEquals(-1111, queue.deQueue());

queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.enqueue(4);

assertEquals(1, queue.deQueue());
assertEquals(2, queue.deQueue());

}
@Test
public void testIsEmpty() {
assertEquals(true, queue.isEmpty());

queue.enqueue(1);
assertEquals(false, queue.isEmpty());
}
@Test
public void testIsFull() {

assertEquals(false, queue.isFull());

queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.enqueue(4);

assertEquals(false, queue.isFull());

queue.enqueue(5);
assertEquals(true, queue.isFull());

}

}