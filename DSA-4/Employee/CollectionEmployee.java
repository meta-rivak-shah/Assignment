import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Surender
 */
public class CollectionEmployee {
	
	ArrayList<Employee> emp = new ArrayList<Employee>();
	Set<Integer> empId = new HashSet<Integer>();
	Scanner input = new Scanner(System.in);

	/**
	 * Method to add a new employee into the list of employees
	 * @param noOfEmployee is the no of employees to add
	 */
	public void addEmployee(int noOfEmployee) {
		int id = 0;
		String name = null;
		String address = null;
		
		for (int index = 0; index < noOfEmployee; index++) {
			
			System.out.println("Enter employee id :");
			id = input.nextInt();
			
			System.out.println("Enter employee name : ");
			input.nextLine();
			name = input.nextLine();
			
			System.out.println("Enter employee address :");
			address = input.nextLine();
			
			if (empId.contains(id)) {
				System.out.println("Emp ID : "+ id +" employee ID already exists !!!!!");
			} else {
				empId.add(id);
				emp.add(addEmployee(id, name, address));
			}
		}
	}

	/**
	 * Method to sort all the employees based on the Emp ID
	 */
	public void sortEmployeeById() {
		for (int indexI = 0; indexI < emp.size() - 1; indexI++) {
			
			for (int indexJ = 0; indexJ < emp.size() - indexI - 1; indexJ++) {
				
				if (emp.get(indexJ).empId > emp.get(indexJ + 1).empId) {
					Employee temp1 = emp.get(indexJ);
					Employee temp2 = emp.get(indexJ + 1);
					emp.set(indexJ, temp2);
					emp.set(indexJ + 1, temp1);
				}
			}
		}
	}
	
	/**
	 * Method to sort all the employees based on the Emp Name
	 */
	public void sortEmployeeByName() {
		for (int indexI = 0; indexI < emp.size() - 1; indexI++) {
			
			for (int indexJ = 0; indexJ < emp.size() - indexI - 1; indexJ++) {
			
				if ((emp.get(indexJ).name).compareTo(emp.get(indexJ + 1).name) > 0) {
					Employee temp1 = emp.get(indexJ);
					Employee temp2 = emp.get(indexJ + 1);
					emp.set(indexJ, temp2);
					emp.set(indexJ + 1, temp1);
				}
			}
		}
	}

	/**
	 * Method to show all the employees in the list
	 */
	public void show() {
		System.out.println("Id \t Name \t Address");
		
		for (int index = 0; index < emp.size(); index++) {
			System.out.println(emp.get(index).empId + "\t" + emp.get(index).name +"\t" + emp.get(index).adress);
		}
	}

	/**
	 * Method to add a new employee into the list of employees 
	 * @param id is the employee id
	 * @param name is the employee id
	 * @param address is the address of the employee
	 * @return an object of the Employee class
	 */
	private Employee addEmployee(int id, String name, String address) {
		return new Employee(id, name, address);
	}

	/**
	 * main Methods
	 */
	public static void main(String... args) {
		CollectionEmployee employee = new CollectionEmployee();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter no of employee : ");
		int noOfEmployee = input.nextInt();
		
		employee.addEmployee(noOfEmployee);
		System.out.println("\nEmployee list :\n");
		employee.show();
		
		System.out.println("\nSort employee by Emp ID :\n");
		employee.sortEmployeeById();
		employee.show();
		
		System.out.println("\nSort employee by name :\n");
		employee.sortEmployeeByName();
		employee.show();
	}
}
