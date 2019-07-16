package get2019.assignment;

/**
 * 
 * @author Rivak sham
 * @class {StringOperation} in this class some basic operation are perfom like 
 * @func getReverseString
 * @func getCompareString
 * @func getLargestWord
 * @func getUpperCaseString
 * @func getLowerCaseString
 * this are the basic function used in it
 * @param string1 this parameter take first string
 * @param string2 this parameter take first string
 */
public class StringOperation {
	
	private String string1;
	private String string2;
	
	/**
	 * @cons StringOperation this constructor initialize the variable 
	 * @param string1 
	 * @param string2
	 */
	public StringOperation(String string1, String string2) {
		super();
		this.string1 = string1;
		this.string2 = string2;
	}
	/**
	 * @func getString1 return string 
	 * @return string
	 */
	public String getString1() {
		return string1;
	}
	
	/**
	 * @func setString1 this function set the string
	 * @param string1
	 */
	public void setString1(String string1) {
		this.string1 = string1;
	}
	/**
	 * @func getString2 return string 
	 * @return string
	 */
	public String getString2() {
		return string2;
	}
	
	/**
	 * @func setString2 this function set the string
	 * @param string1
	 */
	public void setString2(String string2) {
		this.string2 = string2;
	}
	
	/**
	 * @func getReverseString this function take parameter as argument 
	 * and return the reverse of string
	 * @param string
	 * @return
	 */
	public String getReverseString(String string){
		String reverseString="";
		for(int i=string.length(); i>0; i--){
			reverseString=reverseString+string.charAt(i-1);
		}
		return reverseString;
	}
	/**
	 * @func getCompareString this function take two parameter as argument 
	 * and return 0 or 1 if 1 so string is same 
	 * @param string1
	 * @param string2
	 * @return
	 */
	public String getCompareString(String string1 , String string2){
		int flag=0;
		if(string1.length() != string2.length()){
			return "0";
		}
		else{
			for(int i=0; i<string1.length(); i++){
				if(string1.charAt(i)==string2.charAt(i)){
					flag++;
				}
			}
			
			if(flag!=string1.length()){
				return "0";
			}
			else{
				return "1";
			}

		}
		
	}
	/**
	 * @func getLargestWord this function take string as parameter and 
	 * find the largest word from string
	 * @param string
	 * @return string
	 */
	@SuppressWarnings("null")
	public String getLargestWord(String string) {
		String extractword= "";
		string=string+" ";
		int k=0;
		String words[] =  new String[100];
		for(int j=0; j<string.length();j++){
			
			if(' '!=string.charAt(j)){
				extractword=extractword+string.charAt(j);
			}
			else{
				words[k]=extractword;
				extractword="";
				k=k+1;
			}
		}
		
		String  maxWord=words[0];
		int i=0;
		while(null!=(words[i])){
			if(maxWord.length() < words[i].length()){
				maxWord=words[i];
			}
			i=i+1;
		}
		return maxWord;
	}
	/**
	 * @func getUpperCaseString this function take string as argument and return the convert of string into upper case
	 * @param string
	 * @return string
	 */
	public String getUpperCaseString(String string){
		String upperCase="";
		for (int i=0; i<string.length(); i++){
			if(string.charAt(i)==' '){
				upperCase=upperCase+' ';
			}else{
				if(string.charAt(i)>=97 && string.charAt(i)<=122){
					upperCase=upperCase + (char)(string.charAt(i)-32);
				}else{
					upperCase=upperCase + (char)(string.charAt(i));
				}
				//upperCase=upperCase + (char)(string.charAt(i)-32);
			}
		}
		return upperCase;
	}
	/**
	 * @func getLowerCaseString this function take string as argument and return the convert of string into lower case
	 * @param string
	 * @return string
	 */
	public String getLowerCaseString(String string) {
		String lowerCase="";
		for (int i=0; i<string.length(); i++){
			if(string.charAt(i)==' '){
				lowerCase=lowerCase+' ';
			}else{
				if(string.charAt(i)>=65 && string.charAt(i)<=90){
				lowerCase=lowerCase+ (char)(string.charAt(i)+32);
				}else{
					lowerCase=lowerCase+ (char)(string.charAt(i));
				}
			}
		}
		return lowerCase;

	}
	
	
}
