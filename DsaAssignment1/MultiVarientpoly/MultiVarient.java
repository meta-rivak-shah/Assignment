package get2019.dsa.assignment1;

/**
 * this class contain two parameter
 * @param next which is node type
 * @param polynode which is same as class address 
 * @author Rivak
 *
 */
class PolyNode {

	Node1 next;
	PolyNode nextPolyNode;
}

/**
 * class contain constructor which initialize coefficient  , degree , String  and address
 * @author Rivak shah
 */
class Node1 {
	int c;
	String x;
	int d;
	Node1 Next;
	Node1(int c , String x,int d){
		this.c = c;
		this.x = x;
		this.d = d;
	}
}
/**
 * this class contain following function
 * @func insert
 * @func insert1
 * @func printList
 * @func findDegree
 * @author Rivak
 *
 */
public class MultiVarient {
	
	PolyNode head;
	/**
	 * this function create Polynode
	 * @return the refrence of polynode
	 */
	public PolyNode insert() {
		return new PolyNode();
	}
	/**
	 * 
	 * @param c contain coffecient
	 * @param x contain symbol
	 * @param d contain degree
	 * @return refrence of node
	 * 
	 */
	public Node1 insert1(int c , String x,int d) {
		return new Node1(c,x,d);
	}

	/**
	 * this function print the list which passed in argument
	 * @param p1
	 */
	public void printList(PolyNode p1) {
	
		PolyNode p = p1;
		Node1 n1 =null;
		while(p != null){
			n1 = p.next;
			while(n1 != null){
				System.out.print(" "+n1.c+n1.x+"^"+n1.d);
				n1 = n1.Next;
			}
			if(p.nextPolyNode !=null){
				System.out.print(" +");
			}
			p = p.nextPolyNode;
		} 
	}

	/**
	 * 
	 * @param p1 contain the complete list all node
	 * @return the max degree of all polynomial equation
	 */
	public int findDegree(PolyNode p1) {
		if(p1 == null){
			return 0;
		}
		PolyNode p = p1;
		Node1 n;
		int max=-1;
 		while(p != null) {
 			int sum=0;
			n = p.next;
			while(n!=null) { //when n is not equal to null it check and sum all degree
				sum = sum + n.d;
				n = n.Next;
			}
			
			if(sum > max){ //check sum is greter then max value then it update the sum
				max =sum;
			}
			p  = p.nextPolyNode;
		}
 		return max;
	}
	
}
