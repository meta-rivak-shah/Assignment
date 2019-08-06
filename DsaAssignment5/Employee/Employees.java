package DSa5Assignment;
/**
 * class Employees is used to sort the employee salary on the basis of age and salry
 * high salary person will come first and low salary come next and if 
 * both have same salary then check age
 * @author Rivak
 */
class EmpNode {
	String name;
	int age;
	int salary;
	EmpNode nextEmployee;

	/**
	 *Constructor is used to initialize the value of employee   
	 * @param name string type value
	 * @param age int type value
	 * @param salary int type value
	 */
	EmpNode(String name, int age, int salary) {
		this.age = age;
		this.salary = salary;
		this.name = name;
		this.nextEmployee = null;
	}
}

/**
 * the class Employees is used to implement the insertion sorting operaion
 * @author Rivak
 *insertion sorting will sort the employees on the basis of salary and age
 */
public class Employees {
	EmpNode headEmloye = null;
	EmpNode sorted;

	/**
	 * function is used to insert the employee details
	 * employee details are of int type age int type salary string type age
	 * @param name String type value
	 * @param salary int type salary
	 * @param age int type age
	 */
	void insertIntoEmployee(String name, int salary, int age) {
		EmpNode newNode = new EmpNode(name, age, salary);
		if (headEmloye == null) {
			headEmloye = newNode;
		} else {
			EmpNode Temp = headEmloye;
			while (Temp.nextEmployee != null) {
				Temp = Temp.nextEmployee;
			}
			Temp.nextEmployee = newNode;
		}
	}

	/**
	 * function is used to print the data of employees
	 * @return 
	 */
	String[] printList() {
		if(this.headEmloye == null){
			throw new AssertionError();
			}
		EmpNode temp = this.headEmloye;
		String[] nameofemp = new String[8];
		int i =0;
		while (temp != null) {
			//System.out.println(temp.name + " = name" + " - age = " + temp.age+ " - salary = " + temp.salary);
			nameofemp[i] = temp.name;
			i = i + 1;
			temp = temp.nextEmployee;
		}
		return nameofemp;
	}

	/**
	 * this function is used to call the sorting function
	 * which hold refrence of head node and next of head node
	 * @param headref
	 */
	void insertionSort(EmpNode headref) {
		// Initialize sorted linked list
		sorted = null;
		EmpNode current = headref;
		// Traverse the given linked list and insert every
		// node to sorted
		while (current != null) {
			// Store next for next iteration
			EmpNode next = current.nextEmployee;
			// insert current in sorted linked list
			sortedInsert(current);
			// Update current
			current = next;
		}
		// Update head_ref to point to sorted linked list
		this.headEmloye = sorted;
	}

	/*
	 * function to insert a new_node in a list. Note that this function expects
	 * a pointer to head_ref as this can modify the head of the input linked
	 * list (similar to push())
	 */
	void sortedInsert(EmpNode newnode) {

		/* Special case for the head end */
		if (sorted == null || sorted.salary < newnode.salary) {
			newnode.nextEmployee = sorted;
			sorted = newnode;
		} else if (sorted.salary == newnode.salary && sorted.age > newnode.age) {
			newnode.nextEmployee = sorted;
			sorted = newnode;
		} else {
			EmpNode current = sorted;
			/* Locate the node before the point of insertion */
			while (current.nextEmployee != null
					&& current.nextEmployee.salary > newnode.salary) {
				current = current.nextEmployee;
			}

			newnode.nextEmployee = current.nextEmployee;
			current.nextEmployee = newnode;
		}
	}

}
