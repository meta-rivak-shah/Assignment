package get2019.assignment6;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class MultiplyPolyTestCases{
	
	private String expectedResult;
	private static Polynomial Polynomial;
	private static Polynomial Polynomial1;
	@Before
	public void initialize() {
		Polynomial = new Polynomial(new int[]{2,1,1}, new int[]{2,1,0});
		Polynomial1 = new Polynomial(new int[]{2,1,1}, new int[]{2,1,0});
		
	}

	public MultiplyPolyTestCases(String expectedResult,IntSet IntSet1, IntSet  IntSet2) {
	this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
	return Arrays.asList(new Object[][] {
	{"4x^4 4x^3 5x^2 2x^1 1x^0 ",Polynomial,Polynomial1}
	});
	}
	
	@Test
	public void testIntSet1() {
		assertEquals(expectedResult, Polynomial1.multiPoly(Polynomial, Polynomial1));
	}
	
	
}
