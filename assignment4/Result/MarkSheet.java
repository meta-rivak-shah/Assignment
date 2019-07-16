package grades;


public class MarkSheet {
	/**
	 * @param num
	 * @param grades
	 * function returning average of grades
	 */
	public  float average( float grades[] ){
		float average = 0,sum = 0;

		for(int i=0 ; i < grades.length ; i++ ){
			sum = sum + grades[i];
		}
		try{
			average=sum/(grades.length);
		
		}catch(ArithmeticException e){
			  System.out.println ("You Shouldn't divide a number by zero");
		}
		return average;
	}
	/**
	 * @param grades
	 * function returning maximum grade
	 */
	public float maxGrade(  float grades[] ){
		float max = grades[0];
		for(int i=0 ; i < grades.length ; i++ ){
			if(grades[i] > max){
				max = grades[i];
			}
		}
		return max;
	}
	/**
	 * @param grades
	 * function returning minimum grade
	 */
	public float minGrade( float grades[]){
		float min = grades[0];
		for(int i=0 ; i < grades.length ; i++){
			if(grades[i]<min){
				min=grades[i];
			}
		}
		return min;
	}
	/**
	 * @param grades
	 * function returning percentage of students who got more than 40%
	 */
	public float percentageStudentPass(float grades[]){
		int count = 0;
		float percentageStudentPass = 0;
		for(int i=0 ; i < grades.length ; i++ ){
			if(grades[i] >= 40){
				count++;
			}
		}
		try{
		 percentageStudentPass = (count*100)/(grades.length);
		}catch(ArithmeticException e){
			System.out.println("You shouldn't divide number by zero");
		}
		
		return  percentageStudentPass;
	}

}
