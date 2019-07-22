package get2019.assignment6;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class evaluateTestCase {

	private int expectedResult;
	private int value;
	private Polynomial Polynomial;

	@Before
	public void initialize() {
		Polynomial = new Polynomial(new int[] {2,2,2,1},new int[] {4,3,2,0});
	}

	public evaluateTestCase(int expectedResult, int value) {
		this.expectedResult = expectedResult;
		this.value = value;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays.asList(new Object[][] { 
		{ 7,1},
		{ 57,2},
		{1,0}
		});
	}

	@Test
	public void testIntSet1() {
		assertEquals(expectedResult, Polynomial.evalute(value));
	}

}
