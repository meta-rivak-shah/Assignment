package get2019.assignment8;
/**
 * @param category
 * @param cageCapicity
 * @param zoneCount
 * this all Initialize and return Object
 * @author Rivak
 *
 */
public class Zone {
	String category;
	int cageCapity;
	boolean hasPark, hasCanteen;
	Zone(String category , int cageCapity,boolean hasPark , boolean hasCanteen){
		this.category = category;
		this.cageCapity= cageCapity;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	
	}
}
	
