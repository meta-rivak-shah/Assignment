package get2019.dsaAssingment2;

/**
 * this class is the statck interface 
 * which contain all method
 * @func push()
 * @func pop()
 * @func isEmpty()
 * @func display()
 * @author rivakshah
 *
 */
public interface Stack {

	void push(String data);
	void pop ();
	String peak();
	boolean isEmpty();
	void display();
}
