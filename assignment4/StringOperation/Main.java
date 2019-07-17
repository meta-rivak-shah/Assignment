package get2019.assignment;
import java.util.*;

/**
 * 
 * @author Rivak shah
 * @class Main this class conatain some basic operation like 
 * call all the function and print all the result of all operation
 * @AllOperation this array function contain all the operation
 *
 */
public class Main {

	public static void main(String[] args) {
		
		String string1="";
		String string2="";
		
		int checking=0;
		
		int flag=1;
		
		String allOperation[] = new String[]{"Exit","Reverse String","Compare String", "Largest Word","Upper Case","Lower Case"};
		
		Scanner userInput =  new Scanner(System.in);
		
		//this loop check until both string are empthy then it again ask to insert
		while("".equals(string1) || "".equals(string2)){
			if("".equals(string1)){
				System.out.println("Enter your String1");
				string1=userInput.nextLine();
			}
			
			if("".equals(string2)){
				System.out.println("Enter your String2");
				string2=userInput.nextLine();
			}
			
		}
		
		
		StringOperation StringOperationObj = new StringOperation(string1, string2);
		
		while(flag!=0){
			for(int i =0; i<allOperation.length;i++){
				System.out.println(i+" -> "+allOperation[i]);
			}
			
			System.out.println("Enter your choise");
			flag=userInput.nextInt();
			switch(flag){
				case 0:
					System.out.println("You are Exit from Program");
					System.exit(0);
					break;
				case 1:
					String reverseString1=StringOperationObj.getReverseString(StringOperationObj.getString1());
					System.out.println("Your Reverse->"+reverseString1);
					
					String reverseString2=StringOperationObj.getReverseString(StringOperationObj.getString2());
					System.out.println("Your Reverse->"+reverseString2);
					break;
				case 2:
					String compareString1=StringOperationObj.getCompareString(StringOperationObj.getString1() , StringOperationObj.getString2());
					System.out.println("Your Compare result->"+compareString1);
					break;
				case 3:
					String largestString1=StringOperationObj.getLargestWord(StringOperationObj.getString1());
					System.out.println("Your 'largest word->"+largestString1);
					
					String largestString2=StringOperationObj.getLargestWord(StringOperationObj.getString2());
					System.out.println("Your 'largest word->"+largestString2);
					break;
				case 4:
					String uppercaseString1=StringOperationObj.getUpperCaseString(StringOperationObj.getString1());
					System.out.println("Your 'Upper case String->"+uppercaseString1);
					
					String uppercaseString2=StringOperationObj.getUpperCaseString(StringOperationObj.getString2());
					System.out.println("Your 'Upper case  String->"+uppercaseString2);
					break;
				case 5:
					String lowercaseString1=StringOperationObj.getLowerCaseString(StringOperationObj.getString1());
					System.out.println("Your 'Lowecase String is->"+lowercaseString1);
					
					String lowercaseString2=StringOperationObj.getLowerCaseString(StringOperationObj.getString2());
					System.out.println("Your 'Lowecase  String is->"+lowercaseString2);
					break;
			}
			
		}
		
		userInput.close();
	
	}

}
