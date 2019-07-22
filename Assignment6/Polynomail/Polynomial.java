package get2019.assignment6;
/**
 *@class Polynomial have following operation
 *@func evalute
 *@func calculatepower
 *@func addPoly
 *@func findMaxValue
 *@func multiPoly
 *@func linearSearchAlgo
 *@func getDgree
 *@func getCoffcient
 *@param coffecient[]
 *@param degree[]
 */
public final class Polynomial {

	final private int coffecient[];
	final private int degree[];
	/**
	 * constructure is used to intialize the both private varible
	 */
	public Polynomial(int[] coffecient, int[] degree) {

		this.coffecient = coffecient;
		this.degree = degree;
	}
	/**
	 * this function is used to get the value of private variable
	 * @return degree int type array
	 */
	public int[] getCoffecient() {
		return coffecient;
	}
	
	/**
	 * this function is used to get the value of private variable
	 * @return degree int type array
	 */
	public int[] getDegree() {
		return degree;
	}

	/**
	 * this funtion used to evalute the complete polynomial equation
	 * @param value is contain the value of x
	 * @return  evaluteSum which is int type value
	 */
	public int evalute(int value) {
		int evaluteSum = 0;
		for (int i = 0; i < coffecient.length; i++) {
			evaluteSum = evaluteSum + this.getCoffecient()[i] * calculatepower(this.getDegree()[i], value);
		}
		return evaluteSum;
	}
	/**
	 * this funtion used to find the power vlue using recursion
	 * @param value is contain the value of x
	 * @param degree is the degree of the value 
	 * @return 1 if degree is 0
	 */
	private int calculatepower(int degree, int value) {

		if (degree == 0) {
			return 1;
		}

		return value * calculatepower(degree - 1, value);//recursion until degree is not 1
	}
	
	/**
	 * function is used to find degree 
	 * @return int type value 
	 */
	public  int degree() {
		return this.getCoffecient().length;
		
	}

	/**
	 * this function is used to add both polynomial equation
	 * @param Polynomial is class type or object type 
	 * @param polynomial1 is class type of object 
	 * @return array type coffecient
	 */
	public int[] addPoly(Polynomial polynomial,Polynomial polynomial1) {
		int max1 = findMaxValue(polynomial.getDegree());
		int max2 = findMaxValue(polynomial.getDegree());
		if (max1 > max2) {
			
			int  coffecient[] = new int[max1];
		}else {
			
			int  coffecient[] = new int[max2];
		}
		
		int count = 0;
		while (count != coffecient.length) {
			int newCofficent=0;
			for (int i = 0; i < polynomial.getDegree().length; i++) {
				
				if (polynomial.getDegree()[i] == polynomial1.getDegree()[count]) {
					
					newCofficent = polynomial.getCoffecient()[i] + polynomial1.getCoffecient()[count];
					break;
				}
			}
			if(newCofficent != 0){
				coffecient[count] = newCofficent;
				count = count + 1;
			} else {
				
				coffecient[count] = polynomial1.getCoffecient()[count];
				count = count + 1;
			}
		}
		return coffecient;
		
	}

	/**
	 * this function is used to find the max degree value
	 * @return int type value
	 * @param degree is array type
	 */
	private int findMaxValue(int[] degree) {
	
		int maxValue = degree[0];
		for (int i = 0; i < degree.length; i++) {
			
			if (maxValue < degree[i]) {
				
				maxValue = degree[i];
			}
		}
		return maxValue;
	}

	/**
	 * this function is used to multipy both polynimal equation
	 * @param Polynomial is class type or object type 
	 * @param polynomial1 is class type of object 
	 * @return array type coffecient
	 */
	public int[] multiPoly(Polynomial polynomial, Polynomial polynomial1) {
		int allDegree[] = getDgree(polynomial , polynomial1); //return the array type degree
		int allCoffeicent[] = getCoffcient(polynomial , polynomial1); //return the coffecient type array
		int maxDegre = this.findMaxValue(allDegree);
		int count =0; // increase until total degree is not equal
		int value=0; // contain the value of array
		int flag=0; //used to stop to add same value
		int newMultiPlyCoffecient[] = new int[maxDegre];
		int newMultiPlyDegree[] = new int[maxDegre];
		for (int i = 0; i < allDegree.length; i++) {
			flag= 0;
			int evaluteSum=0;
			int linearSearch =allDegree.length;
			while(linearSearch != -1) {
				value = allDegree[i];
				linearSearch = this.linearSearchAlgo(allDegree, value,linearSearch-1);
				//this do linear search of same value for multipy of same degree
				if (linearSearch != -1) { // if value is -1 it stop the loop
					if(allCoffeicent[linearSearch]!= -1){
						evaluteSum = evaluteSum + allCoffeicent[linearSearch];
						allCoffeicent[linearSearch] =-1;
					}else{
						flag =-1;
					}
				}
			}
			if(flag != -1){ // if flag is not equal to -1 then it will add value else leave the value
				newMultiPlyCoffecient[count] =evaluteSum;
				newMultiPlyDegree[count] =value;
				count = count +1;
			}
		}
		for (int i = 0; i < newMultiPlyCoffecient.length; i++) {
			System.out.println(newMultiPlyCoffecient[i]+"m"+newMultiPlyDegree[i]);
		}
		return newMultiPlyDegree;
		
	}
	/**
	 * this is helper method to search given vaue in array
	 */
	private int linearSearchAlgo(int[] allDegree, int value,int index) {
		for (int j = index; j >= 0; j--) {
			if (allDegree[j] == value){
				return j;
			}
		}
		return -1;
	}

	/**
	 * this function is used to find the multiplication of degree
	 * @return allDegree array type int array
	 */
	private int[] getDgree(Polynomial polynomial, Polynomial polynomial1) {
		int allDegree[] = new int[polynomial.getDegree().length * polynomial1.getDegree().length];
		int count=0;
		int j=0;
		while (count != polynomial1.getDegree().length) {
			for (int i = 0; i < polynomial.getDegree().length; i++) {
				if(polynomial.getDegree()[i]==1 || polynomial1.getDegree()[count]==1){
					if(polynomial1.getDegree()[count]==1){
						allDegree[j] = polynomial1.getDegree()[count] * polynomial.getDegree()[i]+1;
						j=j+1;
					}else{
						allDegree[j] = polynomial1.getDegree()[count] * polynomial.getDegree()[i]+1;
						j=j+1;
					}
				}
				else if(polynomial.getDegree()[i]==0 ||polynomial1.getDegree()[count]==0){
					if(polynomial1.getDegree()[count]==0){
						allDegree[j] = polynomial.getDegree()[i];
						j=j+1;
					}else{
						
						allDegree[j] = polynomial1.getDegree()[count];
						j=j+1;
					}
				}
				else{
					allDegree[j] = polynomial1.getDegree()[count] * polynomial.getDegree()[i];
					j=j+1;
				
				}
			}
			count = count + 1;
		}
		for (int i = 0; i < allDegree.length; i++) {
			System.out.print(allDegree[i]+"d");
		}
		return allDegree;
	}
	/**
	 * this funciton is used to find the multiplicaton of coffecient
	 * @return allCoffeicent array type int array
	 */
	private int[] getCoffcient(Polynomial polynomial, Polynomial polynomial1) {
		int allCoffeicent[] = new int[polynomial.getDegree().length * polynomial1.getDegree().length];
		int count=0;
		int j=0;
		while (count != polynomial1.getDegree().length) {
			for (int i = 0; i < polynomial.getDegree().length; i++) {
				allCoffeicent[j] = polynomial1.getCoffecient()[count] * polynomial1.getCoffecient()[i];
				j=j+1;
			}
			count = count + 1;
		}
		System.out.println();
		for (int i = 0; i < allCoffeicent.length; i++) {
			System.out.print(allCoffeicent[i]+"c");
		}
		return allCoffeicent;
	}
	
}
