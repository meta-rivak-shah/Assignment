package dsa.assignment2;

import java.util.ArrayList;

/**
 * the RootNode is used to 
 * Create a Direcotry type node
 * which contain all the imformation about sub Direcorty and parent
 */
class RootNode {

	String name;/Users/rivakshah/Desktop/DsaAssignment3 2/src/dsa/assignment2/Main.java
	RootNode nextRootNode;
	RootNode parentNode;
	ArrayList<RootNode> Children = new ArrayList<RootNode>();
	RootNode(String name) {
		this.nextRootNode = null;
		this.parentNode = null;
		this.name = name; 
	}
}
/**
 * this class is used to operate all the command which is used in command shell
 * Like Mkdir CD Find Cd.. we are create the virtual cmd implementation in this class
 */
public class CommandShell {
	RootNode Root;
	RootNode current =Root;
	CommandShell(){
		 Root = new RootNode("Root");
		 this.current = this.Root;
	}
	/**
	 * the function is used to create a direcotry 
	 * when user type mkdir command 
	 * the direcotry is created
	 */
	void createDirecotry(String name ){
		RootNode newNode = new RootNode(name);
		RootNode temp = this.current;
		temp.Children.add(newNode);
		newNode.parentNode = temp;
	}
	/**
	 * this function is used to print all direcotry and sub Directory
	 * 
	 */
	public void printList(RootNode allDirecotry) {
		if(allDirecotry.Children != null){
			for (int i = 0; i < allDirecotry.Children.size(); i++) {
				System.out.println("\u251c"+allDirecotry.Children.get(i).name);
				printList(allDirecotry.Children.get(i));
			}
		}
		
	}
	/**
	 * this function is used to go inside the Directory
	 * when user type cd command it go inside the Direcotry
	 */
	public String goInsideTheDirectory(String string) {
		RootNode temp = this.current;
		for (int i = 0; i < temp.Children.size(); i++) {
			if(temp.Children.get(i).name.equals(string)){
				this.current = temp.Children.get(i);
				return string;
			}
		}
		return  "No Direcotry found";
	}

	/**
	 * this function is used to come back to parent directory
	 * when user type bc command user come back to direcotry
	 */
	public String goBackToTheDirectory() {
		this.current = this.current.parentNode;// TODO Auto-generated method stub
		return current.name;
	}
	
	/**
	 * this function is used to show the current direcotry f user
	 * where they are
	 */
	public String ShowCurrentDirecotry(){
		this.printList(this.current);
		return this.current.name;
	}
	
	/**
	 * this function is used to find the folder name inside the current folder 
	 * and inside the subfolder also
	 */
	public String findFolder(String string,RootNode allDirecotry) {
		
		if(string.equals(allDirecotry.name)){
			return "yes";
		}
		if(allDirecotry.Children != null){
			for (int i = 0; i < allDirecotry.Children.size(); i++) {
				findFolder(string , allDirecotry.Children.get(i));
			}
		}
		return "No";
	}

}
package dsa.assignment2;

import java.util.ArrayList;

/**
 * the RootNode is used to 
 * Create a Direcotry type node
 * which contain all the imformation about sub Direcorty and parent
 */
class RootNode {

	String name;/Users/rivakshah/Desktop/DsaAssignment3 2/src/dsa/assignment2/Main.java
	RootNode nextRootNode;
	RootNode parentNode;
	ArrayList<RootNode> Children = new ArrayList<RootNode>();
	RootNode(String name) {
		this.nextRootNode = null;
		this.parentNode = null;
		this.name = name; 
	}
}
/**
 * this class is used to operate all the command which is used in command shell
 * Like Mkdir CD Find Cd.. we are create the virtual cmd implementation in this class
 */
public class CommandShell {
	RootNode Root;
	RootNode current =Root;
	CommandShell(){
		 Root = new RootNode("Root");
		 this.current = this.Root;
	}
	/**
	 * the function is used to create a direcotry 
	 * when user type mkdir command 
	 * the direcotry is created
	 */
	void createDirecotry(String name ){
		RootNode newNode = new RootNode(name);
		RootNode temp = this.current;
		temp.Children.add(newNode);
		newNode.parentNode = temp;
	}
	/**
	 * this function is used to print all direcotry and sub Directory
	 * 
	 */
	public void printList(RootNode allDirecotry) {
		if(allDirecotry.Children != null){
			for (int i = 0; i < allDirecotry.Children.size(); i++) {
				System.out.println("\u251c"+allDirecotry.Children.get(i).name);
				printList(allDirecotry.Children.get(i));
			}
		}
		
	}
	/**
	 * this function is used to go inside the Directory
	 * when user type cd command it go inside the Direcotry
	 */
	public String goInsideTheDirectory(String string) {
		RootNode temp = this.current;
		for (int i = 0; i < temp.Children.size(); i++) {
			if(temp.Children.get(i).name.equals(string)){
				this.current = temp.Children.get(i);
				return string;
			}
		}
		return  "No Direcotry found";
	}

	/**
	 * this function is used to come back to parent directory
	 * when user type bc command user come back to direcotry
	 */
	public String goBackToTheDirectory() {
		this.current = this.current.parentNode;// TODO Auto-generated method stub
		return current.name;
	}
	
	/**
	 * this function is used to show the current direcotry f user
	 * where they are
	 */
	public String ShowCurrentDirecotry(){
		this.printList(this.current);
		return this.current.name;
	}
	
	public String findFolder(String string,RootNode allDirecotry) {
		
		if(string.equals(allDirecotry.name)){
			return "yes";
		}
		if(allDirecotry.Children != null){
			for (int i = 0; i < allDirecotry.Children.size(); i++) {
				findFolder(string , allDirecotry.Children.get(i));
			}
		}
		return "No";
	}

}
