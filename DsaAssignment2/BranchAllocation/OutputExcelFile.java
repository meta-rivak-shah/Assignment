package question3;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Test class to test the allocation of program to the students
 * @author Rivak
 * Dated 08/01/2019
 */
public class CollegeCounsellingTest {

	List<Student> allocationList = new ArrayList<>();

	/**
	 * This method gets the data from the AllocationList sheet and generates the allocation list before every test runs
	 */
	@Before
	public void generateAllocatedList() {
		int row;
		try {
			String[] prefrences = new String[5];
			Workbook workbook = Workbook.getWorkbook(new java.io.File("Allocation.xls"));
			Sheet sheet = workbook.getSheet(0);
			String studentName;
			String allocatedCourse ;
			for (row = 0; row < sheet.getRows(); row++) 
			{
					Cell cell = sheet.getCell(0, row);
					studentName = cell.getContents();
					cell = sheet.getCell(1, row);
					allocatedCourse = cell.getContents();
					
					allocationList.add(new Student(studentName, prefrences, allocatedCourse));
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testAllocation1() throws Exception
	{
		CollegeCounseling obj = new CollegeCounseling();
		Queue<Student> queue = obj.allocateStudentsToQueue();
		obj.getProgramList();
		obj.allocateStudentToProgram(queue);
		obj.makeExcelSheet();
		generateAllocatedList();
		String studentName = allocationList.get(0).getName();
		String allocatedProgram = allocationList.get(0).getAllocatedProgram();
		
		assertEquals("Jugal Kukreja", studentName);
		assertEquals("CSE", allocatedProgram);
	}
	
	@Test
	public void testAllocation2() throws Exception
	{
		CollegeCounseling obj = new CollegeCounseling();
		Queue<Student> queue = obj.allocateStudentsToQueue();
		obj.getProgramList();
		obj.allocateStudentToProgram(queue);
		obj.makeExcelSheet();
		generateAllocatedList();
		String studentName = allocationList.get(1).getName();
		String allocatedProgram = allocationList.get(1).getAllocatedProgram();
		
		assertEquals("Aman Gautam", studentName);
		assertEquals("EEE", allocatedProgram);
	}
}
