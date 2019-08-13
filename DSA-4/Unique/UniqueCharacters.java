import java.util.*;

/**
 * @author Surender
 *
 */
public class UniqueCharacters {
	private Map<String, Integer> cache = new HashMap<String, Integer>();
	
	/**
	 * Method to find the number of unique characters in a string
	 * @param string is the input string
	 * @return the number of unique characters in the string
	 */
	public int getUniqueCharactersInAString(String string) {
		int numberOfUniqueCharacters = 1;
		
		// checks if the map contains the already calculated result (like cache system)
		if(cache.containsKey(string)) {
			numberOfUniqueCharacters = cache.get(string); 
			System.out.println("Received from cache");
			return numberOfUniqueCharacters;
		}
		
		List<Character> list = new ArrayList<Character>();
		for (int index = 0; index < string.length(); index++) {
			list.add(string.charAt(index));
		}
		
		for (int index = 1; index < string.length(); index++) {
			if(Collections.frequency(list, string.charAt(index)) == 1) {
				numberOfUniqueCharacters ++;
			}
		}
		
		cache.put(string, numberOfUniqueCharacters);
		System.out.println("Received by calculation");
		return numberOfUniqueCharacters;
	}
}
