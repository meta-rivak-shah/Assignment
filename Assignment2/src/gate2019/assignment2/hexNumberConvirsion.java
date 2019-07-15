package get2019.assignment2;

import java.util.ArrayList;
/*@Class hexNumberConvirsion perform all operation like covert Interger Hex value
 * convert float Hex value convert decimal int value convert dcimal float value 
 * this @param can we assume as positive number and floating point number
 *@func All function are taken as static becuae all are in same package we can call directly 
 *without creation of object
 * */
public class hexNumberConvirsion {
	/*@func getDecimalNumberForInt this function is used t conver the int hex value in decimal value 
	 * @param hexnumber take String value 
	 * @return this function return the int type value
	 * this function perform some basic operation like check every char value 
	 * if char value is between the A to D then it convert this into decimal by 
	 * typecasting and multiply with base 16
	 */
	public static int getDecimalNumberForInt(String hexnumber) {
		int baseForInt = 1;
		
		int decimalNumberforInt = 0;
		
		for (int i = hexnumber.length(); i > 0; i--) {
			
			if ((hexnumber.charAt(i - 1) >= 'A' && hexnumber.charAt(i - 1) <= 'Z')) {

				decimalNumberforInt = decimalNumberforInt+(hexnumber.charAt(i - 1) - 55)*baseForInt;
				
				baseForInt = baseForInt * 16;
			}else{
				
				decimalNumberforInt = decimalNumberforInt+(hexnumber.charAt(i - 1) - 48)*baseForInt;
				
				baseForInt = baseForInt * 16;
			}
		}

		return decimalNumberforInt;
	}
	/*@func getDecimalNuberForFloat this function is used t conver the float hex value in decimal value 
	 * @param hexnumber take String value 
	 * @return this function return the double type value
	 * this function perform some basic operation like check every char value 
	 * if char value is between the A to D then it convert this into decimal by 
	 * typecasting and multiply with base 1/16
	 */
	public static double getDecimalNuberForFloat(String hexNumber){
		
		double decimalNumberforFloat = 0;
		
		double floatbase = (1.0 / 16.0);//when we conver the hex to decimla of float type then base should be 16^-1
		// so we take @parm floatbase as 1/16 which == 16^-1
		
		double baseForFlotingPoint = floatbase;
		
		for (int i = 0; i < hexNumber.length(); i++) {

			if ((hexNumber.charAt(i) >= 'A' && hexNumber.charAt(i) <= 'Z')) {
			
				decimalNumberforFloat = decimalNumberforFloat+(hexNumber.charAt(i) - 55)*baseForFlotingPoint;
				
				baseForFlotingPoint = baseForFlotingPoint * floatbase;
			}
			else{
				
				decimalNumberforFloat = decimalNumberforFloat+ (hexNumber.charAt(i) - 48)* baseForFlotingPoint;
				
				baseForFlotingPoint = baseForFlotingPoint * floatbase;
			}
		}
		return decimalNumberforFloat;
	}
	/*@func getHexString this function is used t conver the int decimal  value in hex value 
	 * @param hexnumber take String value 
	 * @return this function return the String type value
	 * this function perform some basic operation like check every char value 
	 * if char value is between the 10 to 16  then it convert this into hex by 
	 * typecasting 
	 * in this we are taking value by %(mod) method this give remainder 
	 */
	public static String getHexString(String hexNumber){
		ArrayList<Integer> remainder=new ArrayList<Integer>();
		
		//int quotient=0;
		
		int count=0;
		
		String hexString="";
		
		long hexNumber1;

		char converIntToChar = 0;
		hexNumber1=Long.parseLong(hexNumber);
		while(hexNumber1>0){
			remainder.add((int)(hexNumber1%16));
			hexNumber1=hexNumber1/16;
			count=count+1;
		}
		for(int j=remainder.size();j>0;j--){
			if(remainder.get(j-1)>=10&&remainder.get(j-1)<=15){
				
				converIntToChar = (char)(remainder.get(j-1)+55); //convert the each char to hexa decimal y adding 55
				//because we assume every number as Uppercause
				hexString=hexString+converIntToChar;
			}else {
				converIntToChar = (char)(remainder.get(j-1)+48);

				hexString=hexString+converIntToChar;
			}
			
		}
		if(hexString=="") {
			return "0";
		}
		else {
			return hexString;
		}
	}
	/*@func getFloatHexString this function is used t conver the float deciaml value in hex value 
	 * @param hexnumber take String value 
	 * @return this function return the String type value
	 * this function perform some basic operation like check every char value 
	 * if char value is between the A to D then it convert this into decimal by 
	 * typecasting and multiply every number by 16 and the take first number of 
	 * multiply and and agin do this
	 */
	public static String getFloatHexString(String hexString) {
		double hexNumberFloating = Double.parseDouble("0."+hexString);
		
		String floathexString = "";
		
		String converFloatHexString="";
		
		char converIntToChar;
		
		for(int i=0;i<3;i++){
			
			hexNumberFloating=hexNumberFloating*16;
			
			floathexString=floathexString+(int)hexNumberFloating;

			if(Integer.parseInt(floathexString)>=10 && Integer.parseInt(floathexString)<=15){
				
				converIntToChar = (char)(Integer.parseInt(floathexString)+55);//conver the value in hex number
				//here we use all value as capital
				
				floathexString="";

				converFloatHexString=converFloatHexString+converIntToChar;
				
			}else{
				converFloatHexString=converFloatHexString+floathexString;
				
				floathexString="";
			}
			
			if((int)hexNumberFloating-hexNumberFloating==0.0){
				//if the hexNumberFloating-hexNumberFloating multiply and then the after 
				//suctract it the result is 00 then break the loop
				//@example .25*16=120.00
				//120.00-120.00=00 then it should be break becaue ther is no more hex conversion
				break;
			}
			
			hexNumberFloating=hexNumberFloating-(int)hexNumberFloating;
			
		}
		return converFloatHexString;
	}

	
}
