package get2019.dsaAssingment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * this class contain all the operation like
 * 
 * @func readExcel
 * @func addStudent
 * @author rivakshah
 */
public class StudentPrefrence {
	ArrayList<String> Student = new ArrayList<String>();
	ArrayList<ArrayList<String>> Branches = new ArrayList<ArrayList<String>>();
	ArrayList<Student> StudentDetails = new ArrayList<Student>();

	/**
	 * this function readExcel is used to read all the data into the excel file
	 * 
	 * @throws BiffException
	 * @throws IOException
	 */
	public void readExcel() throws BiffException, IOException {
		String FilePath = "C:\\Users\\Rivak\\workspace\\dsaAssingment2\\Students.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		// add the name of all student into Student list
		for (int row = 0; row < totalNoOfRows; row++) {
			Student.add(sh.getCell(0, row).getContents());
		}

		// add the branch of all student into the Branches list
		for (int row = 0; row < totalNoOfRows; row++) {
			ArrayList<String> innerList = new ArrayList<String>();
			for (int col = 1; col < totalNoOfCols; col++) {
				innerList.add(sh.getCell(col, row).getContents());
			}
			Branches.add(innerList);

		}

		// add all the studentDetails into student class and take object of
		// perticular student
		for (int i = 0; i < totalNoOfRows; i++) {
			String name = Student.get(i);
			ArrayList<String> studentBranch = new ArrayList<String>();
			studentBranch = Branches.get(i);
			StudentDetails.add(this.addStudent(name, studentBranch));
		}

	}

	/**
	 * this function is used to add all the student into the list of student
	 * 
	 * @param name
	 *            contain the name of student
	 * @param studentBranch
	 *            contain all the branches of student
	 * @return refrence of student class
	 */
	private Student addStudent(String name, ArrayList<String> studentBranch) {
		return new Student(name, studentBranch);
	}

}
