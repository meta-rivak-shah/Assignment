package get2019.dsaAssingment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;

/**
 * this class contain the following operation
 * 
 * @func studentAllocation
 * @func writeFile
 * @author rivakshah
 *
 */
public class BranchAllocation {
	CounselingProcess Obj1 = new CounselingProcess();
	StudentPrefrence Obj2 = new StudentPrefrence();
	static Queue<String> allocatedBranch = new LinkedList<>();
	static Queue<String> studentName = new LinkedList<>();

	/**
	 * this class is used to read excel file and convert that data into Object
	 * form
	 * 
	 * @param StudentDetails
	 *            this all are list type which contain student type object
	 * @param BranchPrefrence
	 *            this contain all branch prefrence of student
	 * @throws BiffException
	 * @throws IOException
	 */
	public void studentAllocation() throws BiffException, IOException {
		Obj1.readExcel();
		Obj2.readExcel();
		int flag = 0;
		// loop for all student until we had not visited to all
		for (int i = 0; i < Obj2.StudentDetails.size(); i++) {
			// temp varible for perticulat Student Branch
			ArrayList<String> perticulatStudentBranch = new ArrayList<String>();
			perticulatStudentBranch = Obj2.StudentDetails.get(i).BranchPrefrence;
			for (int j = 0; j < perticulatStudentBranch.size(); j++) {
				String studentBranch = perticulatStudentBranch.get(j); // every branch of student
				for (int k = 0; k < Obj1.Programs.size(); k++) {
					if (studentBranch.equals(Obj1.Programs.get(k).branch)) {
						if (Obj1.Programs.get(k).capacity != 0) { // if branch capacity is o then not allocate else allocate it
							allocatedBranch.add(studentBranch);
							studentName.add(Obj2.StudentDetails.get(i).name);
							Obj1.Programs.get(k).capacity = Obj1.Programs
									.get(k).capacity - 1;
							flag = 1;
							break;
						} else {
							// if branch capacity is zero then break the loop
							flag = -1;
							break;
						}
					}
				}
				if (flag == 1) {
					break;
				}
			}
		}
		System.out.println(allocatedBranch);
		System.out.println(studentName);
	}

	/**
	 * this function convert all the queeue data into excel file
	 */
	public static void writeFile() {
		int index = 0;
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File(
					"C://P//AllocateStudentList.xls"));
			WritableSheet workbookSheet = workbook.createSheet("sheet1", 0);
			int index1;
			index = studentName.size();
			for (index1 = 0; index1 < index; index1++) {
				System.out.println(studentName.size());
				String name = studentName.remove();
				Label nameLabel = new Label(0, index1, name);
				workbookSheet.addCell(nameLabel);

				String program = allocatedBranch.remove();
				Label programLabel = new Label(1, index1, program);
				workbookSheet.addCell(programLabel);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws BiffException, IOException {
		BranchAllocation obj = new BranchAllocation();
		obj.studentAllocation();
		obj.writeFile();
	}
}
