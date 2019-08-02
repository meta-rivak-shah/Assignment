package get2019.dsaAssingment2;

/**
 * which contain all implementation of stack method
  * @func push()
 * @func pop()
 * @func isEmpty()
 * @func display()
 * @author rivakshah
 */
public class InfixEvalutiono{
	Node Operand;
	InfixEvalutiono(){
		this.Operand = null;
	}
	/**
	 * this function is used to insert the data into stack
	 */
	public void push(int data) {
		Node newNode = new Node(data);
		if (this.isEmpty()) {
			this.Operand = newNode;
		} else {
			Node temp;
			temp = this.Operand;
			this.Operand = newNode;
			newNode.next = temp;
		}
	}
	/**
	 * this function is used to remove element from the stack
	 */
	public void pop() {
		this.Operand = this.Operand.next;
	}

	/**
	 * this funciton is used to take the first element from stack
	 */
	public int peak() {
		int data = this.Operand.data1;
		return data;
	}
	/**
	 * this function check stack is empty or not
	 */
	public boolean isEmpty() {
		return this.Operand == null;
	}
	/**
	 * this function is used to display the list of all element present 
	 * into the stack
	 */
	public void display() {	
		Node temp = this.Operand;
		while (temp != null) {
			System.out.print(temp.data1 + " ");
			temp = temp.next;
		}
	}
	/**
	 * this function is used to convert the postfix expression evalution
	 * @param result contain the String type postfix result
	 */
	public int evalutionOperation(String result) {
		int count = 0;
		String subString = "";
		String operand;
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) != ' ') {
				subString = subString + result.charAt(i);
			} else {
				int n = 0;
				if (subString.length() != 0) {
					for (int j = 0; j < subString.length(); j++) {
						n = n * 10 + (subString.charAt(j) - 48); //check substring is number 
					}
					if ((n <= -3 && n >= -6) || n == 46) { //check substring is  operator
						this.operationOfExpression(subString);
					} else {
						this.push(n);

					}
				}
				subString = "";
			}
		}
		return this.peak();
	}
	
	/**
	 * this funciton is helper method which is used to
	 * evalute the postfix operation
	 * @param operand
	 */
	private void operationOfExpression(String operand) {
		int val1 = this.peak(); //peak first number from stack
		this.pop(); //remove the first element form stack
		int val2 = this.peak(); //peak second number from stack
		this.pop(); //remove the second element into the stack
		System.out.println();
		switch (operand) {
		case "/":
			System.out.println("div");
			this.push(val2 / val1);
			break;
		case "*":
			System.out.println("mul");
			this.push(val2 * val1);
			break;
		case "-":
			System.out.println("minus");
			this.push(val2 - val1);
			break;
		case "+":
			System.out.println("add");
			this.push(val2 + val1);
			break;
		case "^":
			System.out.println("power");
			int sum = 1;
			for (int j = 0; j < val1; j++) {
				sum = sum * val2;
			}
			this.push(sum);
			break;
		}

	}

}
