package get2019.assignment2;
import java.util.*;
public class Main {

	/*@Class main Shows the result of all operation this we call evry function
	 * here we are import the scanner class and taking input thorugh scanner class
	 * @funct checkHexNumberValidity this function check the user input value is valid or not if it not then it stop the program
	 * */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter Your First Hex Number");
		
		String firstHexNumber=userInput.nextLine();
		
		System.out.println("Enter Your Second Hex Number");
		
		String secondtHexNumber=userInput.nextLine();
		
		checkHexNumberValidity(firstHexNumber.toUpperCase());
		checkHexNumberValidity(secondtHexNumber.toUpperCase());
		
		HexFunction HexFunctionObj =  new HexFunction(firstHexNumber.toUpperCase(), secondtHexNumber.toUpperCase());
		
		HexFunctionObj.convertToDecimal(HexFunctionObj.getFirstHexNumber());
		
		HexFunctionObj.convertToDecimal(HexFunctionObj.getSeccondHexNumber());
		
		String[] hexSplitWords = HexFunctionObj.getFirstHexNumber().split("\\.");//split the user input String in two part to check weather it is int value or float
		
		String[] hexSplitWords1 = HexFunctionObj.getSeccondHexNumber().split("\\.");//split the user input String in two part to check weather it is int value or float
		
		
		if(hexSplitWords.length==2 && hexSplitWords1.length==2){
			//if both split word are length 2 then it do not convert he decimal value to int
			System.out.println("Decimal number1->"+HexFunctionObj.convertToDecimal(HexFunctionObj.getFirstHexNumber()));
			
			System.out.println("Decimal number2->"+HexFunctionObj.convertToDecimal(HexFunctionObj.getSeccondHexNumber()));
			
			//System.out.println("hex number1->"+HexFunctionObj.convertToHex(HexFunctionObj.getFirstHexNumber()));
			
			//System.out.println("hex number2->"+HexFunctionObj.convertToHex(HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("sum is->"+HexFunctionObj.addHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("sub is->"+HexFunctionObj.subtractHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("div is->"+HexFunctionObj.divideHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("mul is->"+HexFunctionObj.multiplyHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
		}
		else if(hexSplitWords.length==2 && hexSplitWords1.length==1){
			//if one split word are length 1 and other is 2 then it change the type one length splitword to int
			System.out.println("A");
			
			System.out.println("Decimal number1->"+HexFunctionObj.convertToDecimal(HexFunctionObj.getFirstHexNumber()));
			
			System.out.println("Decimal number2->"+(int)HexFunctionObj.convertToDecimal(HexFunctionObj.getSeccondHexNumber()));
			
			//System.out.println("hex number1->"+HexFunctionObj.convertToHex(HexFunctionObj.getFirstHexNumber()));
			
			//System.out.println("hex number2->"+HexFunctionObj.convertToHex(HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("sum is->"+HexFunctionObj.addHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));

			System.out.println("sub is->"+HexFunctionObj.subtractHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("div is->"+HexFunctionObj.divideHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("mul is->"+HexFunctionObj.multiplyHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
		}
		else if(hexSplitWords.length==1 && hexSplitWords1.length==2){
			//if one split word are length 1 and other is 2 then it change the type one length splitword to int
			System.out.println("Decimal number1->"+(int)HexFunctionObj.convertToDecimal(HexFunctionObj.getFirstHexNumber()));
			
			System.out.println("Decimal number2->"+HexFunctionObj.convertToDecimal(HexFunctionObj.getSeccondHexNumber()));
			
			//System.out.println("hex number1->"+HexFunctionObj.convertToHex(HexFunctionObj.getFirstHexNumber()));
			
			//System.out.println("hex number2->"+HexFunctionObj.convertToHex(HexFunctionObj.getSeccondHexNumber()));
			
			
			System.out.println("sum is->"+HexFunctionObj.addHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("sub is->"+HexFunctionObj.subtractHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("div is->"+HexFunctionObj.divideHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("mul is->"+HexFunctionObj.multiplyHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
		}
		else{
			//if both split word are length 1  then it change the type both length splitword to int
			System.out.println("Decimal number1->"+(int)HexFunctionObj.convertToDecimal(HexFunctionObj.getFirstHexNumber()));
			
			System.out.println("Decimal number2->"+(int)HexFunctionObj.convertToDecimal(HexFunctionObj.getSeccondHexNumber()));
			
			//System.out.println("hex number1->"+HexFunctionObj.convertToHex(HexFunctionObj.getFirstHexNumber()));
			
			//System.out.println("hex number2->"+HexFunctionObj.convertToHex(HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("sum is->"+HexFunctionObj.addHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()).split("\\.")[0]);
			
			System.out.println("sub is->"+HexFunctionObj.subtractHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()).split("\\.")[0]);
			
			System.out.println("div is->"+HexFunctionObj.divideHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
			
			System.out.println("mul is->"+HexFunctionObj.multiplyHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()).split("\\.")[0]);
			
		}
		
		System.out.println("First HexNumber is Greter->"+HexFunctionObj.findGreterHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
		System.out.println("First HexNumber is less->"+HexFunctionObj.findLessHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
		System.out.println("First HexNumber is Equal->"+HexFunctionObj.findEqualHexNumber(HexFunctionObj.getFirstHexNumber() , HexFunctionObj.getSeccondHexNumber()));
		
		userInput.close();
	}

	static void checkHexNumberValidity(String hexNumber) {
		for(int i=0;i<hexNumber.length()-1;i++){
			if((hexNumber.charAt(i)>=65&&hexNumber.charAt(i)<=70)||(hexNumber.charAt(i)>=48&&hexNumber.charAt(i)<=57)||hexNumber.charAt(i)==46) {
				continue;
			}
			else{
				System.err.println("Insert a Valid Hex Number");
				System.exit(i);
			}
		}
	}
}
