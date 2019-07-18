package gate2019.assignment4;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class CountClumpsTestCase {
	
	private int[] inputArray;
	private int expectedResult;
	private ArrayOperation arrOperations;

	@Before
	public void initialize() {
	arrOperations = new ArrayOperation();
	}

	public CountClumpsTestCase(int expectedResult, int[] inputArray) {
	this.expectedResult = expectedResult;
	this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] {
	{ 1, new int[] {1,1,1,1,1}},
	{ 1, new int[] {4,5,6,6,5,4} },
	{ 2, new int[] { 1, 4, 4, 3, 4, 4, 1}},
	{ 0, new int[] { 1, 4, 5, 3, 5, 4, 1}},
	{ 0, new int[] {1}},
	{ 0, new int[] {}},
	});
	}
	@Test
	public void testMaxMirror() {
		assertEquals(expectedResult, arrOperations.countClumps(inputArray));
	}
}

