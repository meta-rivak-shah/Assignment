package get2019.assignment2;

import java.math.BigDecimal;
import java.util.HashMap;
/*@Class HexFunction perform all operation like addition multiplication
 * divide greaterHexnumber LessHexNumber EqualHexNumber 
 * @extends in this we extend a class hexNumberConvirsion which give hexadecimal to decimal conversion
 * and decimal to hexadecimal conversion
 * @param firstHexNumber take the first Hex number;
 * @param seccondHexNumber take the second hex number;
 * this @param can we assume as positive number and floating point number
 * and both are private member
 * where we use getter setter to set the value and get the value in this
 * */
public class HexFunction extends hexNumberConvirsion {

	private String firstHexNumber;
	private String seccondHexNumber;

	public HexFunction(String firstHexNumber, String seccondHexNumber) {
		this.firstHexNumber = firstHexNumber;
		this.seccondHexNumber = seccondHexNumber;
	}

	/*@fun getFirstHexNumber
	 * return the Firsthexnumber
	 * */
	public String getFirstHexNumber() {
		return firstHexNumber; 
	}
	/*@fun setFirstHexNumber
	 * set the Firsthexnumber
	 * */
	public void setFirstHexNumber(String firstHexNumber) {
		this.firstHexNumber = firstHexNumber;
	}
	/*@fun getSeccondHexNumber
	 * return the Firsthexnumber
	 * */
	public String getSeccondHexNumber() {
		return seccondHexNumber;
	}
	/*@fun setSeccondHexNumber
	 * set the setSeccondHexNumber
	 * */
	public void setSeccondHexNumber(String seccondHexNumber) {
		this.seccondHexNumber = seccondHexNumber;
	}
	/*@fun addHexNumber
	 * function addhexnumber is used to add to hexdecimal number
	 * @param This take two String value as parameter
	 * @return this funciton return the String value
	 * */
	public String addHexNumber(String firstHexNumber , String secondHexNumber){
		double convertTodecimalFirstHexNumber = convertToDecimal(firstHexNumber);
		double convertTodecimalSecondHexNumber = convertToDecimal(secondHexNumber);
		//System.out.println("aa"+);
		return  convertToHex(Double.toString((convertTodecimalFirstHexNumber+convertTodecimalSecondHexNumber)));
	}
	/*@fun subtractHexNumber
	 * function subtractHexNumber is used to substract the hexdecimal number
	 * @param This take two String value as parameter
	 * @return this funciton return the String value
	 * */
	public String subtractHexNumber(String firstHexNumber , String secondHexNumber){
		double convertTodecimalFirstHexNumber = convertToDecimal(firstHexNumber);
		double convertTodecimalSecondHexNumber = convertToDecimal(secondHexNumber);
		if((convertTodecimalFirstHexNumber-convertTodecimalSecondHexNumber==0.0)) {
			return "0.0";
		}
		return  convertToHex(Double.toString(Math.abs(convertTodecimalFirstHexNumber-convertTodecimalSecondHexNumber)));
	}
	/*@fun divideHexNumber
	 * function divideHexNumber is used to divide the hexdecimal number
	 * @param This take two String value as parameter
	 * @return this funciton return the String value
	 * */
	public String divideHexNumber(String firstHexNumber , String secondHexNumber){
		double convertTodecimalFirstHexNumber = convertToDecimal(firstHexNumber);
		double convertTodecimalSecondHexNumber = convertToDecimal(secondHexNumber);
		return  convertToHex(Double.toString((convertTodecimalFirstHexNumber/convertTodecimalSecondHexNumber)));
	}
	/*@fun divideHexNumber
	 * function multiplyHexNumber is used to multiply the hexdecimal number
	 * @param This take two String value as parameter
	 * @return this funciton return the String value
	 * */
	public String multiplyHexNumber(String firstHexNumber , String secondHexNumber){
		double convertTodecimalFirstHexNumber = convertToDecimal(firstHexNumber);
		double convertTodecimalSecondHexNumber = convertToDecimal(secondHexNumber);
		BigDecimal longdoubl1 = new BigDecimal(Double.toString(convertTodecimalFirstHexNumber));
		BigDecimal longdoubl2 = new BigDecimal(Double.toString(convertTodecimalSecondHexNumber));
		BigDecimal longdouble3=longdoubl1.multiply(longdoubl2);
		//System.out.println(longdouble3.toString().split(".00")[0]);
		return  convertToHex(longdouble3.toString());
		
	}
	/*@fun convertToDecimal
	 * function convertToDecimal is used to covert  the hexdecimal number into decimal number 
	 * @param This take one String value as parameter
	 * @return this funciton return the double  value
	 * @func getDecimalNumberForInt it take String as argument and return the decimal value type double
	 * @func getDecimalNuberForFloat it take String as argument and return the dcimal value of float type in String in double form
	 * */
	public double convertToDecimal(String hexNumber) {
		String[] hexSplitWords = hexNumber.split("\\.");//split the String if it iclude '.' in the String
		if (hexSplitWords.length == 1) {
			
			return getDecimalNumberForInt(hexSplitWords[0]); //take String as argument return decimal value in double
		}
		else{
			
			return ((double)getDecimalNumberForInt(hexSplitWords[0])+getDecimalNuberForFloat(hexSplitWords[1])); // return the double value in main program
		}
	}
	/*@fun convertToHex
	 * function convertToHex is used to covert  the Decimal number into Hexadecimal number 
	 * @param This take one String value as parameter
	 * @return this funciton return the double  value
	 * @func getHexString it take String as argument and return the hex value type String
	 * @func getFloatHexString it take String as argument and return the dcimal value of float type in String in String form
	 * */
	public String convertToHex(String hexNumber) {
		String[] hexSplitWords = hexNumber.split("\\.");//split the String if it iclude '.' in the String
		
		if (hexSplitWords.length == 1){
			
			return getHexString(hexNumber);// @return String value
			
		}else{
			
			String hexStringIntPoint;
			String convertFloatHexString;
			
			hexStringIntPoint=getHexString(hexSplitWords[0]);
			
			convertFloatHexString=getFloatHexString(hexSplitWords[1]);//reutrn String value

			return hexStringIntPoint+"."+convertFloatHexString;
			}
	}
	/*@fun findGreterHexNumber
	 * function findGreterHexNumber is used to find the greater hex number int this we assume as firstHex number is gretae then second 
	 * and the cpmare s1.length==s2.length=check every char if s2.char is gretaer the s1 then return false else true 
	 * if both string are equal then it return false
	 * @param This take two String value as parameter
	 * @return this funciton return the boolean value
	 * */
	public boolean findGreterHexNumber(String firstHexNumber , String secondHexNumber) {
		int flag=0;
		int flageqal=0;
		if(firstHexNumber.length()>secondHexNumber.length()) {
			return true;
		}
		
		if(firstHexNumber.length()==secondHexNumber.length()){ //compare every charcter if both string hase same length
			for(int i=0;i<firstHexNumber.length();i++){
				if(firstHexNumber.charAt(i)>secondHexNumber.charAt(i)){
					flag++;//the @var flag is use to check that if flag value is eqal to firsthex length then return true
					continue;
				}
				else if(firstHexNumber.charAt(i)==secondHexNumber.charAt(i)){ //if both char are eqal then it increment @var flageql
					flageqal++;
				}
				else{
					return false;
				}
			}
			if((flag!=firstHexNumber.length()||flag==firstHexNumber.length())&&flageqal!=firstHexNumber.length()) {
				//check that if flag is equal to firstHexNumber.length or not eql and flageqal is also not eqal then it means both are 
				//uneqal value and the firts value is greter 
				return true;
			}
			else if(flageqal==firstHexNumber.length()) {
				return false;
			}
		}
		
		return false;
	}
	/*@fun findLessHexNumber
	 * function findLessHexNumber is used to find the lesster hex number int this we assume as firstHex number is lesser then second 
	 * and the cpmare s1.length==s2.length=check every char if s2.char is less then s1 then return false else true 
	 * if both string are equal then it return false
	 * @param This take two String value as parameter
	 * @return this funciton return the boolean value
	 * */
	public boolean findLessHexNumber(String firstHexNumber , String secondHexNumber) {
		int flag=0;
		int flageqal=0;
		if(firstHexNumber.length()<secondHexNumber.length()) {
			return true;
		}
		
		if(firstHexNumber.length()==secondHexNumber.length()) {
			for(int i=0;i<firstHexNumber.length();i++){
				if(firstHexNumber.charAt(i)<secondHexNumber.charAt(i)){
					flag++;
					continue;
				}
				else if(firstHexNumber.charAt(i)==secondHexNumber.charAt(i)){
					flageqal++;
				}
				else{
					return false;
				}
			}
			if((flag!=firstHexNumber.length()||flag==firstHexNumber.length())&&flageqal!=firstHexNumber.length()) {
				return true;
			}
			else if(flageqal==firstHexNumber.length()) {
				return false;
			}
		}
		
		return false;
	}
	/*@fun findEqualHexNumber
	 * function findLessHexNumber is used to find the eqal hex number int this we assume as firstHex number is lesser then second 
	 * and the cpmare s1.length==s2.length=check every char if s2.char is less then s1 then return false else also false 
	 * if both string are equal then it return true
	 * @param This take two String value as parameter
	 * @return this funciton return the boolean value
	 * */
	public boolean findEqualHexNumber(String firstHexNumber , String secondHexNumber){
		int flag=0;
		int flageqal=0;
		if(firstHexNumber.length()>secondHexNumber.length()) {
			return false;
		}
		
		if(firstHexNumber.length()==secondHexNumber.length()) {
			for(int i=0;i<firstHexNumber.length();i++){
				if(firstHexNumber.charAt(i)<secondHexNumber.charAt(i)){
					flag++;
					continue;
				}
				else if(firstHexNumber.charAt(i)==secondHexNumber.charAt(i)){
					flageqal++;
				}
				else{
					return false;
				}
			}
			if((flag!=firstHexNumber.length()||flag==firstHexNumber.length())&&flageqal!=firstHexNumber.length()){
				//check that if flag is equal to firstHexNumber.length or not eql and flageqal is also not eqal then it means both are 
				//uneqal value
				return false;
			}
			else if(flageqal==firstHexNumber.length()) {
				return true;
			}
		}
		return false;
		
	}
}

