/**
 * @author Surender
 * This class implements the constructor and getters, setters Methods for keeping information of an employee 
 */
public class Employee {
	int empId;
	String name;
    String adress;
	
	public Employee(int empId, String name, String adress) {
		this.empId = empId;
		this.name = name;
		this.adress = adress;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
