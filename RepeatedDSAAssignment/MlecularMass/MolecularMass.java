package session2019;

import java.util.HashMap;
import java.util.Stack;
/**
 * the class molecularMAss is basically calculate the total mass of chemical equatin
 like ch3 mass of chh3 is 12+1*3=15
 *stack operation is used in it to solve this equation
 * @author Rivak
 *
 */
public class MolecularMass {

	HashMap<Character, Integer> unique = new HashMap<>();//to bind element with their molecular mass 

	/*
	* constructure is usde to initlize the chemical value of hashMap
	*/
	MolecularMass() {
		unique.put('C', 12);
		unique.put('H', 1);
		unique.put('O', 16);
		unique.put('(', 0);
	}

	//used to do all push pop operation in this class
	Stack<Integer> Molecule = new Stack<Integer>();

	int molecularmass = 0;
	/*
	* this function is used to check that given element is number or not
	if number return true or else flase
	*/
	boolean isNumber(char element) {

		if (element >= 48 && element <= 57) {
			return true;
		}
		return false;
	}
	/*
	* this function is used to check that given element is latter  or not
	if latter return true or else flase
	*/
	boolean isAlbhabate(char element) {
		if (element >= 65 && element <= 97) {
			return true;
		}
		return false;
	}

	/*
	this function return molecular mass of given element
	like if element is c then it return molecular mass is 12
	*/
	int getMolecularMass(char element) {

		return unique.get(element);
	}

	/*
	* this function is used to claculate the molecualr mass of given 
	*chemical reaction
	*/
	int calculateMolecularMass(String formula) {
		if(formula == ""){ //if formula is empty return error
			throw new AssertionError();
		}
		if(formula == null){ //if enter null then return error
			throw new AssertionError();
		}

		formula = formula.toUpperCase();
		//function check string is valid or not
		this.checkValidChmicalString(formula);
		for (int i = 0; i < formula.length(); i++) {
			if (this.isAlbhabate(formula.charAt(i))) {
				Molecule.push(this.getMolecularMass(formula.charAt(i)));

			} else if (this.isNumber(formula.charAt(i))) {
				int base = 0;
				while (this.isNumber(formula.charAt(i))) {
					base = base * 10 + (formula.charAt(i) - 48);
					i++;
					if(i == formula.length()){
						break;
					}
					
				}
				i--;
				int popElement = this.Molecule.pop() * base;
				this.Molecule.push(popElement);
			}
			else if (formula.charAt(i) == '(') {
				this.Molecule.push(this.getMolecularMass(formula.charAt(i)));
			}
			
			else if(formula.charAt(i) == ')'){
				int j  = 0;
				int sum=0;
				while(this.Molecule.peek() !=0){
					sum = sum + this.Molecule.pop();
				}
				this.Molecule.pop();
				this.Molecule.push(sum);
			}

		}
		//calculate the total mass of chemical equation
		while (!this.Molecule.empty()) {
			this.molecularmass = this.molecularmass + this.Molecule.pop();
		}

		return molecularmass;

	}

	//check every is element is between the given range of latter or number
	void checkValidChmicalString(String formula) {
			for (int i = 0; i < formula.length(); i++) {
			if((formula.charAt(i) >=65 && formula.charAt(i) <= 97)||(formula.charAt(i)>=48 && formula.charAt(i)<=57)){
				continue;
			}	
			else if(formula.charAt(i) == '(' && formula.charAt(i) == ')') {
				continue;
			}
			else {
				throw new AssertionError();
			}
		}
	}

}
