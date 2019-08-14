package DSa5Assignment;
/**
 * the interface is used to implement all the function in dict class
 * @author Rivak
 *
 */
public interface Dictionary {
	String getVlaue(int key , Dict root );
	void deleteKey(int key);
	void sortDict(Dict root);
	void sortForKey(int key1 , int key2 ,Dict root);
	void implementDict(int key, String value, Dict Root);
}
