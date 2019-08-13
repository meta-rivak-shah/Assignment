package get2019.dsaAssingment2;

import java.util.ArrayList;

/**
 * this class contain the
 * 
 * @param BranchPrefrence
 * @param name
 * @author rivakshah
 *
 */
public class Student {

	String name;
	ArrayList<String> BranchPrefrence = new ArrayList<String>();

	Student(String name, ArrayList<String> BranchPrefrence) {
		this.name = name;
		this.BranchPrefrence = BranchPrefrence;
	}
}
