package DSa5Assignment;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

	public static void main(String[] args) throws Exception   {
		DictionaryImplementation obj  = new DictionaryImplementation();
        Object obj1 = new JSONParser().parse(new FileReader("C:/Users/Rivak/workspace/Dsa-5/src/DSa5Assignment/input.json.txt")); 
        JSONObject jo = (JSONObject) obj1; 
        Iterator<Map.Entry> itr1 = jo.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
 
            obj.implementDict(Integer.valueOf((String) pair.getKey() ), (String)pair.getValue() , obj.getRoot());
        } 
		obj.printList(obj.getRoot());
		System.out.println("-------------------------------------------------1");
		System.out.println(obj.getVlaue(1, obj.getRoot()));
		System.out.println("-------------------------------------------------2");
		obj.sortDict(obj.getRoot());
		System.out.println("-------------------------------------------------3");
		obj.sortForKey(4, 7, obj.getRoot());
		System.out.println("-------------------------------------------------4");
		obj.deleteKey(1);
		System.out.println("-------------------------------------------------5");
		obj.printList(obj.getRoot());
		System.out.println("-------------------------------------------------6");
		
	}

}
