/**
 * This class represent employee
 
 */
public class Employee {

	// Employee id
	private int empId;
	// Employee name
	private String empName;
	// Employee address
	private String empAdress;
	// Employee salary
	private double empSalary;
	// Employee age
	private double empAge;

	/**
	 * Parameterized constructor used to initialise employee id,name,address,salary,age
	 * 
	 * @param empId integer value represent unique id for employee
	 * @param empName String value represent employee name
	 * @param empAdress String value represent employee address
	 * @param empSalary double value represent employee salary
	 * @param empAge  double value represent employee age
	 */
	public Employee(int empId, String empName, String empAdress,
			double empSalary, double empAge) {

		this.empId = empId;
		this.empName = empName;
		this.empAdress = empAdress;
		this.empSalary = empSalary;
		this.empAge = empAge;
	}

	/**
	 * This method return employee id
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * This method set the employee id
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * This method return the employee name
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * This method set the employee name
	 * @param empNamethe empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * This method return employee address
	 * @return the empAdress
	 */
	public String getEmpAdress() {
		return empAdress;
	}

	/**
	 * This method set the employee address
	 * @param empAdress the empAdress to set
	 */
	public void setEmpAdress(String empAdress) {
		this.empAdress = empAdress;
	}

	/**
	 * This method return the employee salary
	 * @return the empSalary
	 */
	public double getEmpSalary() {
		return empSalary;
	}

	/**
	 * This method set the employee salary
	 * 
	 * @param empSalarythe empSalary to set
	 */
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	/**
	 * This method return the employee age
	 * @return the empAge
	 */
	public double getEmpAge() {
		return empAge;
	}

	/**
	 * This method set the employee age
	 * @param emp Age the empAge to set
	 */
	public void setEmpAge(double empAge) {
		this.empAge = empAge;
	}
}