package get2019.assignment6;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DegreeTestCase {

	private int expectedResult;
	private static Polynomial Polynomial1;
	@Before
	public void initialize() {
		Polynomial1 = new Polynomial(new int[] {2,2,2,1},new int[] {4,3,2,0});
	}

	public DegreeTestCase(int expectedResult) {
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays.asList(new Object[][] { 
		{4}
		});
	}

	@Test
	public void testIntSet1() {
		assertEquals(expectedResult, Polynomial1.degree());
	}

}
