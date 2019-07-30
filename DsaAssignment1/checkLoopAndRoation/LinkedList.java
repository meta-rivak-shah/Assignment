package get2019.dsa.assignment1;

import java.util.HashSet;

/**
 * This class Node Contain
 * Constructor which initialize the value data and next part of node as null
 * @param data is int type contain data
 * @param next is object type which contain address
 * @author Rivak
 *
 */
class Node {
	public Node next;
	public int data;
	/**
	 * Default constructor
	 */
	Node() {
	}
	/**
	 * 
	 * @param data contain data of node
	 * @param next contain address of next node
	 */
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

/**
 * this class contain following operation like 
 * @func insert1
 * @func insert
 * @func rotateList
 * @func checkLoop
 * @author Rivak
 *
 */
public class LinkedList {
	/**
	 * this function insert the data through array
	 * this function create the complete node 
	 * @param data
	 * @return the head node  which created
	 */
	public Node insert1(int data[]) {
		Node node = null;
		for (int i = 0; i < data.length; i++) {
			Node newNode = new Node(data[i]); // create a new Node and insert data into it
			if (node == null) {
				node = newNode;
			} else {
				Node node1 = node;
				while (node1.next != null) { //If node is null insert new into last
					node1 = node1.next;
				}
				node1.next = newNode;
			}
		}
		return node;
	}
	/**
	 * this function also creata a node but it return the node reference
	 * @param data the data filled which we insert into the node
	 * @return the Node object reference to user
	 */
	public Node insert(int data) {
		return new Node(data); 
	}

	public void printList(Node n1) {

		while (n1 != null) {

			System.out.print(" |__" + n1.data + "__|");
			n1 = n1.next;
		}
		System.out.println();
	}

	/**
	 * 
	 * @param n1  contain the node list
	 * @param L  contain the left side index
	 * @param R contain the right side index
	 * @param rotation contain how many rotation do you want
	 * @param size contain the size of output array according to there size
	 * @return the output array which contain all the rotation list
	 */
	public int[] rotateList(Node n1, int L, int R, int rotation, int size) {

		int output[] = new int[size];
		int count = 1;
		Node roation = n1; 
		Node next = null;
		Node prev = null;
		Node curr = null;
		Node Last = null;
		Node New1 = new Node();
		while (roation.next != null) {

			if (count == L) { //take the address of first Left index node
				curr = roation;  //L point node index
				next = roation.next; // address of next node of left point
			}
			if (count == R - 1) { //take the address of Right index node
				Last = roation.next; // contain the right +1 index address
				prev = roation; //contain right node address
			}

			if (count != L && count < L) {
				Node temp = New1;  // also create a temp list which element leave before left node address
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = this.insert(roation.data); 
			}

			roation = roation.next;
			count = count + 1;
		}
		// this.printList(prev);
		for (int i = 0; i < rotation; i++) {
			if (curr == null) {  //if the last l and r  at same node
				return new int[0];
			} else if (next.next == null) { //if l and r have no element inside it
				return new int[0];
			} else if (next.next.next == null) { // if l and are have only one element inside it
				return output;
			}
			curr.next = next.next;    //first update the address of current node next address
			prev.next = next;	//then put next address to previous node next address
			next.next = Last; //update next of next address to last address
			prev = next;  //now again make previous to next one
			next = curr.next; //update next node to current next address
		}

		Node new2 = New1;
		while (new2.next != null) {
			new2 = new2.next;
		}
		new2.next = curr;
		New1 = New1.next;
		System.out.println();
		this.printList(New1);
		int index = 0;
		while (New1 != null) {
			output[index] = New1.data;
			index = index + 1;
			New1 = New1.next;
		}
		return output;
	}

	/**
	 * 
	 * @param n1 contain the list of all element
 	 * @return true or false if loop detect return true else false
	 */
	public boolean checkLoop(Node n1) {
		Node temp1 = n1; //create a temp node
		int flag = -1; 
		HashSet<Node> s = new HashSet<Node>(); // contain the address of all node unique not insert same address again
		while (temp1 != null) {
			if (s.contains(temp1)) {  //check if present address is present inside the hash set  the loop detect else containue
				flag = 1;
				break;
			} else {
				s.add(temp1); //add visited node address to hash set
			}
			temp1 = temp1.next;
		}
		if (flag == -1) {  //if value of flag update means loop not present else present
			return false;
		} else {
			return true;
		}

	}
}
