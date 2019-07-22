package get2019.assignment6;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class AddPolyTestCaseTest{
	
	private int expectedResult[];
	private static Polynomial Polynomial;
	private static Polynomial Polynomial1;
	@Before
	public void initialize() {
		Polynomial = new Polynomial(new int[]{2,8,9,10}, new int[]{2,1,0,3});
		Polynomial1 = new Polynomial(new int[]{2,3,4,1}, new int[]{2,1,3,0});
		
	}

	public AddPolyTestCaseTest(int expectedResult[],IntSet IntSet1, IntSet  IntSet2) {
	this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
	return Arrays.asList(new Object[][] {
	{new int[]{4,11,14,10},Polynomial,Polynomial1},
	});
	}
	
	@Test
	public void testIntSet1() {
		assertArrayEquals(expectedResult, Polynomial1.addPoly(Polynomial, Polynomial1));
	}
	
	
}
