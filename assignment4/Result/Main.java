package grades;
import java.util.Scanner;
public class Main {
	public static void main(String args[]){
		Scanner userInput  =  new Scanner(System.in);  
		MarkSheet marksheezt = new MarkSheet();
		System.out.println("Enter number of students");
		int num= userInput.nextInt();
		float []grades = new float[num];
		for(int i=0 ; i < num ; i++){
			System.out.println("Enter grade of "+ (i+1) +" student")
			grades[i] = userInput.nextFloat();
		}
		float average = marksheet.average(grades);
		float maxgrade = marksheet.maxGrade(grades);
		float mingrade = marksheet.minGrade(grades);
		float perstudentpass = marksheet.percentageStudentPass(grades);
		System.out.println("Average of grades=" + average);
		System.out.println("Maximum grade is=" + maxgrade);
		System.out.println("Minimum grade is=" + mingrade);
		System.out.println("Percentage of students passed=" + perstudentpass+"%");
	}
}
