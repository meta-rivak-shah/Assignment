package get2019.dsaAssingment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * this class contain following funcion
 * 
 * @func readExcel
 * @func addPrograms
 * @author rivakshah
 *
 */
public class CounselingProcess {
	ArrayList<String> Branch = new ArrayList<String>();
	ArrayList<Integer> capacity = new ArrayList<Integer>();
	ArrayList<Programs> Programs = new ArrayList<Programs>();

	/**
	 * this fucntion is used to read the excel file and take form it
	 * 
	 * @throws BiffException
	 * @throws IOException
	 */
	public void readExcel() throws BiffException, IOException {
		String FilePath = "C:\\Users\\Rivak\\workspace\\dsaAssingment2\\Programs.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		// loop is used to add all the branch into the branch list
		for (int row = 0; row < totalNoOfRows; row++) {

			Branch.add(sh.getCell(0, row).getContents());
		}

		// loop is used to add all the capacity of branch into branch list
		for (int row = 0; row < totalNoOfRows; row++) {

			capacity.add(Integer.parseInt(sh.getCell(1, row).getContents()));
		}
		// loop is used to add all the program Object into program list
		for (int i = 0; i < totalNoOfRows; i++) {
			Programs.add(this.addPrograms(Branch.get(i), capacity.get(i)));
		}

	}

	/**
	 * this function is used to add all the program itnto the program list
	 * object type
	 * 
	 * @param capacity
	 *            contian the capacity of branch
	 * @param Branch
	 *            contian the name of branch
	 * @return refrence of Programs class
	 */
	private Programs addPrograms(String Branch, Integer capacity) {
		return new Programs(Branch, capacity);
	}
}
