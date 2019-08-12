import java.util.LinkedList;

/**
 * This class contain method to perform operation on employees
 */
public class EmployeeOperation {

	// LinkedList which contain employee list
	LinkedList<Employee> employeeList = new LinkedList<Employee>();

	/**
	 * This method is use to add employee to employee list
	 * @param employeeobject of Employee class containing details of employee to be added
	 * @return true if added successfully else false
	 */
	public boolean addEmployee(Employee employee) throws Exception {

		try {
			this.employeeList.add(employee);
			
		} catch (Exception e) {
			throw e;
			
		}
		return true;
	}

	/**
	 * This method is use to sort employee according to their salary in descending order
	 * @return LinkedList<Employee> containing all employee details
	 * @throws Exception when employee list is empty
	 */
	public LinkedList<Employee> getSortedEmployeeList() throws Exception {

		try{
			if(this.employeeList.isEmpty()){ 
				throw new Exception("Employee list empty");
			}
			
		}catch(NullPointerException e) {
			System.out.println(e);
			
		}
		return quickSort(employeeList, 0, employeeList.size()-1);
	}
	
	/**
	 * This method is use to sort the employee list using quick sort on their salary
	 * @param employeeList LinkedList<Employee> containing all employee details
	 * @param employeeListStartIndex start index of list
	 * @param employeeListEndIndex end index of list
	 * @return LinkedList<Employee> containing sorted employee according to salary
	 */
	private LinkedList<Employee> quickSort(LinkedList<Employee> employeeList,int employeeListStartIndex, int employeeListEndIndex){
	
		try{
			if(employeeListStartIndex >= employeeListEndIndex) {
				return employeeList;
			}
			int pivotEmployeeIndex = employeeListEndIndex;
			int currentEmployeeIndex = employeeListEndIndex-1;

			while(currentEmployeeIndex >= employeeListStartIndex) { 
				if(employeeList.get(currentEmployeeIndex).getEmpSalary() < employeeList.get(pivotEmployeeIndex).getEmpSalary()) {
					arrangeEmployeePosition(currentEmployeeIndex,pivotEmployeeIndex);
					pivotEmployeeIndex = currentEmployeeIndex;
				} else if(employeeList.get(currentEmployeeIndex).getEmpSalary() == employeeList.get(pivotEmployeeIndex).getEmpSalary()) {
					if(this.employeeList.get(currentEmployeeIndex).getEmpAge() > this.employeeList
							.get(pivotEmployeeIndex).getEmpAge()) {
						arrangeEmployeePosition(currentEmployeeIndex, pivotEmployeeIndex);
						pivotEmployeeIndex = currentEmployeeIndex;
					}
				}
				currentEmployeeIndex--;
			}
			employeeList = quickSort(employeeList, employeeListStartIndex, pivotEmployeeIndex-1);
			employeeList = quickSort(employeeList, pivotEmployeeIndex+1, employeeListEndIndex);
			return employeeList;
		} catch(Exception e) {
			System.out.println(e);
			throw e;
		}
		
	}

	/**
	 * This method is used to rearrange employee position in list
	 * @param employeeNewIndex new index of employee
	 * @param employeeOldIndex old index of employee
	 */
	private void arrangeEmployeePosition(int employeeNewIndex, int employeeOldIndex) {

		try {
			Employee employee = this.employeeList.get(employeeOldIndex);
			this.employeeList.remove(employeeOldIndex);
			this.employeeList.add(employeeNewIndex, employee);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			
		}
	}
}