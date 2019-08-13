package get2019.dsaAssingment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTestCase {
	@Test
	public void TestRotation1() {
		StackImplementation Obj = new StackImplementation();
		String infix = "1+2*4";
		for (int i = 0; i < infix.length(); i++) {
			Obj.push(String.valueOf(infix.charAt(i)));
		}
		InfixToPostFixConversion list = new InfixToPostFixConversion();
		Node String = Obj.getTop();
		Obj.display();
		int result = obj.convertToPostfix(String);
		assertEquals(8, result);
	}

	@Test
	public void TestRotation2() {
		StackImplementation Obj = new StackImplementation();
		String infix = "1+2+3+4*4";
		for (int i = 0; i < infix.length(); i++) {
			Obj.push(String.valueOf(infix.charAt(i)));
		}
		InfixToPostFixConversion list = new InfixToPostFixConversion();
		Node String = Obj.getTop();
		Obj.display();
		int result = obj.convertToPostfix(String);
		assertEquals(22, result);
	}
	
	@Test
	public void TestRotation3() {
		StackImplementation Obj = new StackImplementation();
		String infix = "1*4/1^3";
		for (int i = 0; i < infix.length(); i++) {
			Obj.push(String.valueOf(infix.charAt(i)));
		}
		InfixToPostFixConversion list = new InfixToPostFixConversion();
		Node String = Obj.getTop();
		Obj.display();
		int result = obj.convertToPostfix(String);
		assertEquals(1, result);
	}
}