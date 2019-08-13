package get2019.dsaAssingment2;
/**
 * this class contain stack memory
 * @param data is used to insert data
 * @param next is used to insert next address
 * @param data1 is used to insert int data
 * @author rivakshah
 *
 */
class Node {

	String data;
	Node next;
	int data1;

	/**
	 * construcutre which is used for Strnig data insert
	 * @param data
	 */
	Node(String data) {
		this.data = data;
		this.next = null;
	}
	/**
	 * construcutre which is used for int data insert
	 * @param data
	 */
	Node(int data1) {
		// System.out.println(data1+"ds");
		this.data1 = data1;
		this.next = null;
	}
}

/**
 * this class is the implementation of stack class
 * which contain all implementation of stack method
  * @func push()
 * @func pop()
 * @func isEmpty()
 * @func display()
 * @author rivakshah
 */
public class StackImplementation implements Stack {

	private Node top;
	
	//initilize the top 
	StackImplementation() {
		this.top = null;
	}

	/**
	 * this function is used to insert the data into stack
	 */
	@Override
	public void push(String data) {
		Node newNode = new Node(data);
		if (this.isEmpty()) {
			this.top = newNode;
		} else {
			Node temp;
			temp = this.top;
			this.top = newNode;
			newNode.next = temp;
		}
	}

	/**
	 * this function is used to remove element from the stack
	 */
	@Override
	public void pop() {
		this.top = this.top.next;
	}

	/**
	 * this funciton is used to take the first element from stack
	 */
	@Override
	public String peak() {
		String data = this.top.data;
		return data;
	}


	/**
	 * this function check stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return this.top == null;
	}

	/**
	 * this function is used to display the list of all element present 
	 * into the stack
	 */
	@Override
	public void display() {
		Node temp = this.top;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * 
	 * @returnc the top 
	 */
	public Node getTop() {
		return this.top;
	}
	


}
