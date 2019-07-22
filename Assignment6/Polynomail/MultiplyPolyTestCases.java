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
	
	private int expectedResult[];
	private static Polynomial Polynomial;
	private static Polynomial Polynomial1;
	@Before
	public void initialize() {
		Polynomial = new Polynomial(new int[]{2,1,1}, new int[]{4,1,0});
		Polynomial1 = new Polynomial(new int[]{2,1,1}, new int[]{2,1,0});
		
	}

	public MultiplyPolyTestCases(int expectedResult[],IntSet IntSet1, IntSet  IntSet2) {
	this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
	return Arrays.asList(new Object[][] {
	{new int[]{4,11,14,10},Polynomial,Polynomial1}
	});
	}
	
	@Test
	public void testIntSet1() {
		assertArrayEquals(expectedResult, Polynomial1.multiPoly(Polynomial, Polynomial1));
	}
	
	
}
