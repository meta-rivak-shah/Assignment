package get2019.assignment6;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class IntSetTestCases{
	
	private int expectedResult;
	private IntSet IntSet1;
	@Before
	public void initialize() {
		IntSet1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9});
	}

	public IntSetTestCases(int expectedResult) {
	this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
	return Arrays.asList(new Object[][] {
	{8}
	});
	}
	
	@Test
	public void testIntSet1() {
		assertEquals(expectedResult, IntSet1.sizeOfSet());
	}
	
	
}

