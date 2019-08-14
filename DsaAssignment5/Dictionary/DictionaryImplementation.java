package DSa5Assignment;

/**
 * class is used to create a dist type node 
 * which hold the address of left right and key value
 * @author Rivak
 *
 */
class Dict {
	int key;
	String value;
	Dict left;
	Dict right;

	/**
	 * Constructor is used to initialize the  key value 
	 * and null the left and right
	 * @param value
	 * @param key
	 */
	Dict(String value, int key) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

/**
 * the class implement the dictionary interface which have following operation like
 * find key
 * sort key
 * sort between key
 * delete key
 * @author Rivak
 *
 */
public class DictionaryImplementation implements Dictionary {
	private Dict Root;
	String a = "";
	Dict prev;

	/**
	 * function return the root element
	 * @return
	 */
	public Dict getRoot() {
		return Root;
	}
	
	/**
	 * Constructor is used to initialize the value of root
	 */
	DictionaryImplementation() {
		this.Root = null;
	}

	/**
	 * function is used to get value of perticular key
	 */
	@Override
	public String getVlaue(int key, Dict root) {
		Dict temp = root;
		if (temp.key == key) {
			a = temp.value;
			return a;
		}
		//if key is samll then temp key then call to other left child
		if (temp.key > key) {
			if (temp.left != null) {
				getVlaue(key, temp.left); 
			} else {
				a = "No Match Found";
			}
			//if key is big then temp key then call to other right child
		} else {
			if (temp.right != null) {
				getVlaue(key, temp.right);
			} else {
				a = "No Match Found";
			}
		}
		return a;

	}

	/**
	 * function is used to delete the key in tree
	 */
	 public void deleteKey(int key) 
	    { 
	        this.Root = this.deleteRec(this.getRoot(), key); 
	    } 
	  
	    /* A recursive function to insert a new key in BST */
	    Dict deleteRec(Dict root, int key) 
	    { 
	        /* Base Case: If the tree is empty */
	        if (root == null)  return root; 
	  
	        /* Otherwise, recur down the tree */
	        if (key < root.key) 
	            root.left = deleteRec(root.left, key); 
	        else if (key > root.key) 
	            root.right = deleteRec(root.right, key); 
	  
	        // if key is same as root's key, then This is the node 
	        // to be deleted 
	        else
	        { 
	            // node with only one child or no child 
	            if (root.left == null) 
	                return root.right; 
	            else if (root.right == null) 
	                return root.left; 
	  
	            // node with two children: Get the inorder successor (smallest 
	            // in the right subtree) 
	            root.key = minValue(root.right); 
	  
	            // Delete the inorder successor 
	            root.right = deleteRec(root.right, root.key); 
	        } 
	  
	        return root; 
	    } 
	  
	    /**
	     * function is used to find the in order successor 
	     * @param root reference of head node
	     * @return int type minimum value
	     */
	    int minValue(Dict root) 
	    { 
	        int minv = root.key; 
	        while (root.left != null) 
	        { 
	            minv = root.left.key; 
	            root = root.left; 
	        } 
	        return minv; 
	    } 
	    
	    /*
	     * function is used to sort the value dict
	     */
	@Override
	public void sortDict(Dict root) {
		Dict temp = root;
		if (temp == null) {
			return;
		}
		printList(temp.left);
		System.out.println(temp.key + "->" + temp.value);
		printList(temp.right);

	}

	/**
	 * function is used to sort the key in between the two key
	 * when user insert the two key key1 and key2 then it will sort in 
	 * between the sort
	 */
	@Override
	public void sortForKey(int key1, int key2, Dict root) {

		Dict temp = root;
		if (temp == null) {
			return;
		}
		sortForKey(key1, key2, temp.left);
		if (temp.key >= key1 && temp.key <= key2) {
			System.out.println(temp.key + "->" + temp.value);
		}
		sortForKey(key1, key2, temp.right);
	}

	/**
	 * function is used to print the complete key value pair
	 * @param root
	 */
	public void printList(Dict root) {
		Dict temp = root;
		if (temp == null) {
			return;
		}
		printList(temp.left);
		System.out.println(temp.key + "->" + temp.value);
		printList(temp.right);

	}

	/**
	 * the function is used to insert the key and value in the dict
	 * user pass two key and value then it will insert into it
	 */
	@Override
	public void implementDict(int key, String value, Dict Root) {
		Dict temp = Root;
		Dict newNode = new Dict(value, key);
		if (this.Root == null) {
			this.Root = newNode;
		}

		else if (temp.key > key) {
			if (temp.left == null) {
				temp.left = newNode;
			} else {
				temp = temp.left;
				implementDict(key, value, temp);
			}
		}

		else if (temp.key < key) {

			if (temp.right == null) {
				temp.right = newNode;
			} else {
				temp = temp.right;
				implementDict(key, value, temp);
			}
		}

	}

}
