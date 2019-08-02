package get2019.dsaAssingment2;
/**
 * this class is the implementation of stack class
 * which contain all implementation of stack method
  * @func push()
 * @func pop()
 * @func isEmpty()
 * @func display()
 * @author rivakshah
 */

public class InfixToPostFixConversion implements Stack{
	Node Operator;
	//intilize the operator
	InfixToPostFixConversion(){
		this.Operator = null;
	}
	
	/**
	 * this function is used to insert the data into stack
	 */
	@Override
	public void push(String data) {
		Node newNode = new Node(data);
		if (this.isEmpty()) {
			this.Operator = newNode;
		} else {
			Node temp;
			temp = this.Operator;
			this.Operator = newNode;
			newNode.next = temp;
		}	
	}
	/**
	 * this function is used to remove element from the stack
	 */
	@Override
	public void pop() {
		this.Operator = this.Operator.next;
	}
	/**
	 * this funciton is used to take the first element from stack
	 */
	@Override
	public String peak() {
		String data = this.Operator.data;
		return data;
	}
	/**
	 * this function check stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return this.Operator == null;
	}
	/**
	 * this function is used to display the list of all element present 
	 * into the stack
	 */
	@Override
	public void display() {
		Node temp = this.Operator;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}
	/**
	 * this function is used to check priotiy of operator
	 * @param data contain the operator
	 * @return int form priority
	 */
	int checkPriority(String data) {

		if (data == "^") {
			return 3;
		} else if (data == "+" || data == "-") {
			return 1;
		} else if (data == "*" || data == "/") {
			return 2;
		} else {
			return -1;
		}

	}

	/**
	 * this function is used to check wether data is operator bracket or number
	 * @param data string type
	 * @return the int from number
	 */
	int checkLetterOrDigitBracket(String data) {
		if (data.charAt(0) >= 42 && data.charAt(0) <= 47) {
			return 1;
		} else if (data.charAt(0) == '^') {
			return 1;
		} else if (data.charAt(0) >= 48 && data.charAt(0) <= 57) {
			return 2;
		} else if (data.charAt(0) == '(') {
			return 3;
		} else {
			return -1;
		}
	}
	/**
	 * this function is used to convert the infix expression into the postix
	 * @param top contain the infix expression in it
	 */
	void convertToPostfix(Node top) {
		Node temp = top;
		String result = "";
		//until the top is not get null
		while (temp != null) {
			//check the opertor or number or bracket
			if (this.checkLetterOrDigitBracket(temp.data) == 1) {
				if (this.isEmpty()) {
					this.push(temp.data);
				} else {
					//pop the opertor according to priority
					while ((this.checkPriority(this.peak()) >= this.checkPriority(temp.data))) {
						result = result + this.peak() + " ";
						this.pop();
						if (this.isEmpty()) {
							break;
						}
					}
					//push the operator hase low priority
					this.push(temp.data);
				}
			} else if (this.checkLetterOrDigitBracket(temp.data) == 2) {
				result = result + temp.data + " ";
			} else if (this.checkLetterOrDigitBracket(temp.data) == 3) {
				this.push(temp.data);
			} else if (this.checkLetterOrDigitBracket(temp.data) == -1) {
				while (!this.isEmpty() && this.peak() != "(") {

					result = result + this.peak() + " ";
					this.pop();
				}
				this.pop();
			}
			temp = temp.next;

		}
		//last operator in the list
		result = result + this.peak()+" ";
		InfixEvalutiono obj = new InfixEvalutiono();
		obj.evalutionOperation(result);
	}



}
