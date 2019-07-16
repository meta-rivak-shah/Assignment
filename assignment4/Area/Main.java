package gate2019.assignment;

import java.util.Scanner;
 

/**
 * 
 * @author Rivak shah
 * @class Main this class conatain some basic operation like 
 * call all the function and print all the result of all operation
 * @AllOperation this array function contain all the operation
 *
 */
public class Main{

	public static void main(String[] args) {
		
		float length , width , side , radius ,height ,base;
		
		String AllOperation[] = new String[]{"Exit","Area of Rectangle","Area of Square","Area of Circle","Area of Triangle"};
		
		Scanner userInput = new Scanner(System.in);
		
		Area AreaOnj =  new Area();
		
		int flag=1;
		while(flag!=0){
			for(int i=0; i<AllOperation.length; i++){
				System.out.println(i + " => " + AllOperation[i]);
			}
				System.out.println("Enter Your Choise");
				flag = userInput.nextInt();
				switch(flag){
					case 0:
						System.out.println("You Are Exit");
						System.exit(0);
					case 1:
						System.out.println("Enter Length");
						length = userInput.nextFloat();
						
						System.out.println("Enter Width");
						width = userInput.nextFloat();
						
						System.out.printf("Result : %.2f" , AreaOnj.areaOfRectangle(length , width));
						break;
					case 2:
						System.out.println("Enter Side");
						side = userInput.nextFloat();
				
						System.out.printf("Result : %.2f" , AreaOnj.areaOfSquare(side));
						break;
						
					case 3:
						System.out.println("Enter Radius");
						radius = userInput.nextFloat();
				
						System.out.printf("Result : %.1"
								+ "f", AreaOnj.areaOfRadius(radius));
						break;
						
					case 4:
						System.out.println("Enter Height");
						height = userInput.nextFloat();
						
						System.out.println("Enter base ");
						base = userInput.nextFloat();
				
						System.out.printf("Result : %.2f" , AreaOnj.areaOfTriangle(height , base));
						break;
					default:
						System.out.println("Insert A valid Input");
				}
		}
		userInput.close();
	}

}
