package session2019;

import java.util.HashMap;
/**
 * the class is used to find unique char in the strnig
 * @eg "asdfgsdfg" unique is a
 * @author Rivak
 
 */
public class UniqueCharacter {
		
	   HashMap<Character, Integer> unique = new HashMap<>(); 
	   int unique1=0;
	   /**
	    * function is used to find the unique char in the string if string hase five 
	    * unique char then it return 5 as a output
	    * if it hase null or empty string return {@link AssertionError}
	    * @param string
	    * @return
	    */
	   int foundUnique(String string){
		   
		   if(string == ""){
			   throw new AssertionError();
		   }
		   //insert unique in the map
		   for (int i = 0; i < string.length(); i++) {
			   if(!unique.containsKey(string.charAt(i))){
				unique.put(string.charAt(i) , 1);
			   }
			   else{
				   int count  = unique.get(string.charAt(i));
				   count++;
				   unique.put(string.charAt(i), count);
				   
			   }
		   }
		   // find the unique in the map
		   for (int i = 0; i <string.length(); i++) {
			   if(unique.get(string.charAt(i)) == 1){
				   unique1++;   
			   }
		   }
		return unique1;
		   
	   }
	   
}
