package gate2019.assignment4;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class fixXYTestOperation {
	
	private int[] inputArray;
	private int[] expectedResult;
	private int X;
	private int Y;
	private ArrayOperation arrOperations;

	@Before
	public void initialize() {
	arrOperations = new ArrayOperation();
	}

	public fixXYTestOperation(int[] expectedResult, int[] inputArray, int X, int Y) {
	this.expectedResult = expectedResult;
	this.inputArray = inputArray;
	this.X = X;
	this.Y = Y;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] {
	{  new int[] {9, 4, 5, 4, 5, 9}, new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5},
	{ new int[] {1, 4, 5, 1,}, new int[] { 1, 4, 1, 5 }, 4, 5},
	{ new int[] {1, 4, 5, 1, 1, 4,5}, new int[] {1, 4, 1, 5, 5, 4,1}, 4, 5},
	{ new int[] {}, new int[] {}, 4, 5},
	{new int[] {}, new int[] {4,4,5,5,5,4,4,4}, 4, 5},
	});
	}
	@Test
	public void testMaxMirror() {
		assertArrayEquals(expectedResult, arrOperations.fixXY(inputArray, X, Y));
	}
}

