import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

/**
 * This is test class which test EmployeeOperation class methods
 */
public class EmployeeOperationTest {

	/**
	 * This test method test positive cases on getSortedEmployeeList method of
	 * EmployeeOperation class
	 */
	@Test
	public void testGetSortEmployeeList() {

		try {
			Employee emp1 = new Employee(1, "Vinod", "udaipur", 20000, 21);
			Employee emp2 = new Employee(2, "Rajesh", "UP", 20000, 22);
			Employee emp3 = new Employee(3, "Sohel", "jaipur", 25000, 22);
			Employee emp4 = new Employee(4, "Dev", "jaipur", 30000, 21);
			Employee emp5 = new Employee(5, "Yash", "jaipur", 40000, 23);

			EmployeeOperation empOperation = new EmployeeOperation();
			empOperation.addEmployee(emp1);
			empOperation.addEmployee(emp2);
			empOperation.addEmployee(emp3);
			empOperation.addEmployee(emp4);
			empOperation.addEmployee(emp5);

			LinkedList<Employee> expectedList = new LinkedList<Employee>();
			expectedList.add(emp5);
			expectedList.add(emp4);
			expectedList.add(emp3);
			expectedList.add(emp1);
			expectedList.add(emp2);

			LinkedList<Employee> actualList = empOperation
					.getSortedEmployeeList();

			for (int empIndex = 0; empIndex < expectedList.size(); empIndex++) {
				assertTrue(expectedList.get(0).getEmpName()
						.equalsIgnoreCase(actualList.get(0).getEmpName()));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}